FROM openjdk:8
ADD target/kaddem-1.0.jar kaddem.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "kaddem.jar"]
