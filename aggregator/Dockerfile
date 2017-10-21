FROM node:alpine

ADD bin/            /app/bin
ADD package.json    /app/package.json

WORKDIR /app

RUN npm install

ADD services.json   /app/services.json
ADD app.js          /app/app.js

CMD npm start
