FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY build/libs/post-1.0.0.jar ./user.jar
EXPOSE 8082:8082
CMD ["java", "-jar", "/app/user.jar"]