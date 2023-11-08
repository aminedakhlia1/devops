# Using an official OpenJDK image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable JAR file and any other necessary files
COPY target/gestion-station-ski-1.0.jar .

EXPOSE 8089

# Set the command to run the Spring Boot application
CMD ["java", "-jar", "gestion-station-ski-1.0.jar"]
