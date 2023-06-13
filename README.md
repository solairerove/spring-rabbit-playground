### Env
```shell
➜  ~ mvn -v
Apache Maven 3.8.3 (ff8e977a158738155dc465c6a97ffaf31982d739)
Maven home: /Users/solairerove/.sdkman/candidates/maven/current
Java version: 17.0.6, vendor: Eclipse Adoptium, runtime: /Users/solairerove/.sdkman/candidates/java/17.0.6-tem
Default locale: en_RU, platform encoding: UTF-8
OS name: "mac os x", version: "13.4", arch: "aarch64", family: "mac"
```

### Docker
```shell
docker run -d --hostname my-rabbit --name some-rabbit-management -p 8089:15672 -p 5672:5672 rabbitmq:3-management
```

### Produce message
```shell
curl --location 'localhost:8081/api/message/broadcast' \
--header 'Content-Type: application/json' \
--data '{
  "id": 1,
  "name": "solairerove"
}'
```

```shell
curl --location 'localhost:8081/api/message/send' \
--header 'Content-Type: application/json' \
--data '{
   "routingKey":"email",
   "user":{
      "id":1,
      "name":"solairerove"
   }
}'
```

```shell
curl --location 'localhost:8081/api/message/send' \
--header 'Content-Type: application/json' \
--data '{
   "routingKey":"delivery.t",
   "user":{
      "id":1,
      "name":"solairerove"
   }
}'
```