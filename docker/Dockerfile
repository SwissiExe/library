# Use a multi-stage build for efficiency
FROM maven:3.8.6-openjdk-alpine AS builder

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies (offline mode for faster builds)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code (consider excluding unnecessary files with .dockerignore)
COPY src ./src

# Build the application (skip tests for faster builds)
RUN mvn clean package -DskipTests

# Use a slimmer base image for the final layer
FROM openjdk:19-alpine

# Set working directory
WORKDIR /app

# Copy the built application from the previous stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
