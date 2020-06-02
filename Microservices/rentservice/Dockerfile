FROM openjdk:8-jdk-alpine
LABEL maintainer="markaya@uns.ac.rs"
EXPOSE 8080
WORKDIR /app
COPY target/rentservice-0.0.1-SNAPSHOT ./
CMD ["java", "-jar", "rentservice-0.0.1-SNAPSHOT.jar"]
