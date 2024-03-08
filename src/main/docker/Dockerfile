FROM adoptopenjdk/openjdk11:latest
WORKDIR /app
COPY ../../../target/academy-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8085
CMD ["java","-jar","app.jar"]