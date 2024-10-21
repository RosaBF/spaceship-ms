FROM openjdk:21-jdk-alpine

WORKDIR /app

COPY target/*.jar spaceship-ms.jar

ENTRYPOINT ["java","-jar","/app/spaceship-ms.jar"]