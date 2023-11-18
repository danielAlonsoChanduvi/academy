FROM adoptopenjdk/openjdk11:latest
WORKDIR /app
COPY target/academy-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","app.jar"]