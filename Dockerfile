FROM eclipse-temurin:latest

WORKDIR /app

COPY target/*.jar spaceship-ms.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/spaceship-ms.jar"]