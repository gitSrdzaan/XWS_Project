FROM openjdk:8-jdk-alpine
LABEL maintainer="markaya@uns.ac.rs"
EXPOSE 8080
WORKDIR /app
COPY target/searchservice-0.0.1-SNAPSHOT.jar ./
CMD ["java", "-jar", "searchservice-0.0.1-SNAPSHOT.jar"]
