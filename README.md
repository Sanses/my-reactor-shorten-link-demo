# Reactive Link Shortener Sample Application

[Check step by step video on YouTube](https://www.youtube.com/watch?v=J9jQoFiP41A)

[![Developing reactive application with Spring WebFlux and Spring Data Redis](https://img.youtube.com/vi/KrxXdnCxiFg/0.jpg)](https://www.youtube.com/watch?v=KrxXdnCxiFg)

This repository contains source code for YouTube video where I go through the process of building complete application
from scratch using:

- Java 8
- Spring Boot 2
- Spring WebFlux
- Spring Data Redis
- TestContainers
- Maven


./mvnw package

java -jar target/demo-0.0.1-SNAPSHOT.jar

docker run -p 6479:6379 redis

curl -XPOST http://localhost:8080/link -H "Content-Type: application/json" -d '{"link":"http://wiki.thesanse.com"}'
