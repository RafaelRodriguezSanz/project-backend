FROM openjdk:8
WORKDIR /app
COPY target/backend-*.*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
