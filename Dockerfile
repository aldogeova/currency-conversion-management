# Use base image with JDK 21
FROM openjdk:21-jdk-slim

#Copy the compiled file
COPY build/libs/*.jar app.jar

# Expose port 9090
EXPOSE 9090

#Execute the app with prod profile
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=prod", "app.jar"]
