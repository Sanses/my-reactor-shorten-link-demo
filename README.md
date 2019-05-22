# Reactive Link Shortener Sample Application

[Check step by step video on YouTube](https://www.youtube.com/watch?v=J9jQoFiP41A)

[![Developing reactive application with Spring WebFlux and Spring Data Redis #1](https://img.youtube.com/vi/KrxXdnCxiFg/0.jpg)](https://www.youtube.com/watch?v=KrxXdnCxiFg)

[![Developing reactive application with Spring WebFlux and Spring Data Redis #2](https://img.youtube.com/vi/fTIttl-Z4mk/0.jpg)](https://www.youtube.com/watch?v=fTIttl-Z4mk)

This repository contains source code for YouTube video where I go through the process of building complete application
from scratch using:

- Java 8
- Spring Boot 2
- Spring WebFlux
- Spring Data Redis
- TestContainers
- Maven

# Docker Container로 실행

- 빌드
./mvnw clean package

- Docker 이미지 생성
docker build -t reactor-demo:1.0 .

- redis 실행 이름을 redis로 설정
docker run -d -p 6379:6379 --name redis redis

- demo어플리케이션 실행 --link로 redis명 설정
docker run -d -p 80:8080 --link redis reactor-demo:1.0

- Restfull 호출해 보기
curl -XPOST http://localhost/link -H "Content-Type: application/json" -d '{"link":"http://wiki.iisanse.com"}'


# Docker-compose로 실행
## 빌드
- ./mvnw clean package

## Docker 이미지 생성
- docker build -t sooabia/reactor-demo:2.0 .

## Docker 이미지 PUSH
- docker push sooabia/reactor-demo:2.0

## Docker compose로 멀티컨테이너 실행
- docker-compose -f deploy/dockercompose.yml up -d

## Restfull 호출해 보기
- curl -XPOST http://localhost/link -H "Content-Type: application/json" -d '{"link":"http://wiki.iisanse.com"}'

# kubernetes로 실행
## 사전조건
kubenetes config

## 빌드
- ./mvnw clean package

## Docker 이미지 생성
- docker build -t sooabia/reactor-demo:3.0 .

## Docker 이미지 PUSH
- docker push sooabia/reactor-demo:3.0

## kubernetes에 배포하기
- kubectl apply -f deploy/k8s-deploy.yml

## kubernetes배포 상태 확인하기 
- kubectl get pod
- kubectl get svc

## Restfull 호출해 보기
- curl -XPOST http://localhost/link -H "Content-Type: application/json" -d '{"link":"http://wiki.iisanse.com"}'
