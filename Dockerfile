# Using an official OpenJDK image
FROM openjdk:8-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file and any other necessary files
COPY target/StationDeSki-0.0.1.jar .

EXPOSE 8089

# Set the command to run the Spring Boot application
CMD ["java", "-jar", "StationDeSki-0.0.1.jar"]
