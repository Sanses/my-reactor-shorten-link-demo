FROM maven:3.5-jdk-8 AS build
WORKDIR /usr/app
COPY . /usr/app
COPY pom.xml /usr/app
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:8-jdk-alpine
COPY --from=build /usr/app/target/*.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]