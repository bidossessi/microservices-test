var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
const url = require('url')
const logger = require('morgan');
const _ = require('lodash');
const services = require('./services.json');

var app = express();
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser())

const httpPromise = function(url) {
  // return new pending promise
  return new Promise((resolve, reject) => {
    // select http or https module, depending on reqested url
    const lib = url.startsWith('https') ? require('https') : require('http');
    const request = lib.get(url, (response) => {
      // handle http errors
      if (response.statusCode < 200 || response.statusCode > 299) {
         reject(new Error('Failed to load page, status code: ' + response.statusCode));
       }
      // temporary data holder
      const body = [];
      // on every content chunk, push it to the data array
      response.on('data', (chunk) => body.push(chunk));
      // we are done, resolve promise with those joined chunks
      response.on('end', () => resolve(body.join('')));
    });
    // handle connection errors of the request
    request.on('error', (err) => reject(err))
    })
};

function dispatchPath(parsedUrl, name, endpoint) {
  // TODO: add the params
  let newPath = parsedUrl.pathname.replace(name, endpoint.name)
  return `${endpoint.protocol}://${endpoint.host}:${endpoint.port}${endpoint.rootPath}${newPath}`
}


function serviceDispatch(req, res, next) {
  let parsedUrl = url.parse(req.url);
  let service = _.find(services, o => {
    return parsedUrl.pathname.includes(o.name)
  });
  if (service == undefined) {
    return res.status(500).send('No service found')
  }

  let promises = service.endpoints.map(endpoint => {
    let newUrl = dispatchPath(parsedUrl, service.name, endpoint)
    console.log(`Dispatching request from public endpoint ${req.originalUrl} to internal endpoint ${newUrl} (${endpoint.type})`);
    return httpPromise(newUrl)
  })

  Promise.all(promises)
  .then(values => {
    let result = _.extend({}, ...values.map( o => JSON.parse(o)))
    res.json(result)
  })
  .catch( error => {
    console.log(error)
    res.status(500).send(error)
  });

};


app.get('/', function(req, res) {
  res.json({
    message: "Aggregator is alive.",
    services
  });
});

app.use('/v1', serviceDispatch)

module.exports = app;
