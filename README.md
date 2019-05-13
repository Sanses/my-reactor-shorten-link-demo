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


# 빌드
./mvnw clean package

# Docker 이미지 생성
docker build -t <dockerId>/reactor-demo:1.0 .

# Docker 이미지 Push
docker push <dockerId>/reactor-demo:1.0

# redis 실행 이름을 redis로 설정
docker run -d -p 6379:6379 --name redis redis

# demo어플리케이션 실행 --link로 redis명 설정
docker run -d -p 8080:8080 --link redis sooabia/reactor-demo:1.0

# Restfull 호출해 보기
curl -XPOST http://localhost:8080/link -H "Content-Type: application/json" -d '{"link":"http://wiki.thesanse.com"}'

d
