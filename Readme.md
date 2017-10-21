# Microservice patterns case study

There are currently 3 services:
- customers
- billing
- aggregator

## Run

```
$ docker-compose build
$ docker-compose up
```

### Test the profile service
```
$ curl http://localhost:8001/v1/profile/1
{"id":1,"profile":{"FirstName":"John","PhoneNumber":"+213232323","LastName":"Wayne"}}%
```

### Test the purchases service
```
$ curl http://localhost:8002/v1/history/1
{"id":1,"purchases":[{"product_id":1,"name":"Cool product","price":17.3,"created_on":1508605587539},{"product_id":2,"name":"Other thing","price":3.0,"created_on":1508605587539},{"product_id":3,"name":"Expensive stuff","price":237.5,"created_on":1508605587539}]}%
```

### Test the aggregator
```
$ curl http://localhost:8000/v1/account/1
{"id":1,"profile":{"FirstName":"John","PhoneNumber":"+213232323","LastName":"Wayne"},"purchases":[{"product_id":1,"name":"Cool product","price":17.3,"created_on":1508605625117},{"product_id":2,"name":"Other thing","price":3,"created_on":1508605625117},{"product_id":3,"name":"Expensive stuff","price":237.5,"created_on":1508605625117}]}%
```
