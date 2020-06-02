FROM openjdk:8-jdk-alpine
LABEL maintainer="markaya@uns.ac.rs"
EXPOSE 8080
WORKDIR /app
COPY target/rentacar-0.0.1-SNAPSHOT ./
CMD ["java", "-jar", "rentacar-0.0.1-SNAPSHOT.jar"]
