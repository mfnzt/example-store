FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
RUN mkdir /app
COPY target/example-store-0.0.1-SNAPSHOT.jar /app/example-store.jar
COPY target/classes/application-docker.properties /app/application.properties
WORKDIR /app
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","example-store.jar"]

