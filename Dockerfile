# Use an official OpenJDK runtime as a base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY build/libs/ts-sso-service-1727-0.0.1-SNAPSHOT.jar ts-sso-service-1727-0.0.1-SNAPSHOT.jar

# Expose port 1727 to the outside world
EXPOSE 1727

# Command to run your application
CMD ["java", "-jar", "ts-sso-service-1727-0.0.1-SNAPSHOT.jar"]
