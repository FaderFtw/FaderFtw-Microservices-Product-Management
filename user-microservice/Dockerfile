FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/user-microservice-1.0.0.jar app.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "app.jar"]
