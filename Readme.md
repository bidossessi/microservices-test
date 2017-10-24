# Microservice patterns case study

There are currently 4 services:
- customers (SpringBoot + Jetty)
- billing (SpringBoot + Jetty)
- warehouse (SpringBoot + Jetty)
- aggregator (NodeJS Express)

## Build
Install Gradle , Docker and docker-compose

```
$ ./build_all_services.sh
$ docker-compose up
```

## Communication

The services use in-memory stores, so UUIDs are randomized at every restart

### Test the profile service (seeded)
```
$ curl http://localhost:8001/v1/profile/1
{"id":1,"profile":{"FirstName":"John","PhoneNumber":"+213232323","LastName":"Wayne"}}%
```

### Check the valid purchases
```
$ curl http://localhost:8002/v1/purchase/1/valid
[]%
```

### Check the pickings
```
$ curl http://localhost:8003/v1/picking
[]%
```

### Check the pending purchases (seeded)
```
$ curl http://localhost:8002/v1/purchase/1/pending
[{"id":"8a5f54d7-e20a-4890-84f4-a9b6829f269b","product_id":1,"name":"Cool product","price":17.3,"qty":1,"updated_on":1508853765393},{"id":"e4eb34ea-ebcd-4f12-bb20-0813064241e4","product_id":2,"name":"Other thing","price":3.0,"qty":1,"updated_on":1508853765393},{"id":"aa50b2c5-052f-46eb-b186-a4b6c53b0db3","product_id":3,"name":"Expensive stuff","price":237.5,"qty":1,"updated_on":1508853765393}]%
```

### Confirm a purchase
```
$ curl -X POST http://localhost:8002/v1/purchase/1/confirm/8a5f54d7-e20a-4890-84f4-a9b6829f269b
true%
```

### Check the valid purchases (again)
```
$ curl http://localhost:8002/v1/purchase/1/valid
[{"id":"8a5f54d7-e20a-4890-84f4-a9b6829f269b","product_id":1,"name":"Cool product","price":17.3,"qty":1,"updated_on":1508853765393}]%
```

### Check the pickings (again)
```
$ curl http://localhost:8003/v1/picking
[{"id":"34e86f86-e8d7-4c35-af46-e6417b499249","customer_id":1,"product_id":1,"move_qty":1,"status":"Provisionned","created_on":1508853810590,"updated_on":1508853810591}]%
```


## Check the aggregator
```
$ curl http://localhost:8000/v1/account/1
{"id":1,"profile":{"LastName":"Wayne","FirstName":"John","PhoneNumber":"+213232323"},"purchases":[{"id":"8a5f54d7-e20a-4890-84f4-a9b6829f269b","product_id":1,"name":"Cool product","price":17.3,"qty":1,"updated_on":1508855028236}]}
```
