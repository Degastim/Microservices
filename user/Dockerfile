FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY build/libs/user-1.0.0.jar ./user.jar
EXPOSE 8081:8081
CMD ["java", "-jar", "/app/user.jar"]