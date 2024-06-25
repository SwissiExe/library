# Use a slim Java 17 image as the base
FROM openjdk:22-slim

# Set working directory in the container
WORKDIR /app

# Copy the application JAR file from the context
COPY ${target_dir}/*.jar app.jar

# Expose the port your application runs on (replace 8080 with your actual port)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
