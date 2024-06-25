# Stage 1: Build the application
FROM maven:3.8.6-openjdk-17 AS build

# Install Oracle OpenJDK 22
RUN apt-get update && apt-get install -y wget && \
    wget https://download.oracle.com/java/22/latest/jdk-22_linux-x64_bin.deb && \
    dpkg -i jdk-22_linux-x64_bin.deb && \
    update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-22/bin/java 1 && \
    update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk-22/bin/javac 1 && \
    rm jdk-22_linux-x64_bin.deb && \
    apt-get clean

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM oraclelinux:8-slim

# Install Oracle OpenJDK 22
RUN yum -y install oraclelinux-developer-release-el8 && \
    yum-config-manager --enable ol8_developer && \
    yum -y install java-22-openjdk java-22-openjdk-devel && \
    yum clean all && \
    rm -rf /var/cache/yum

# Set the working directory
WORKDIR /app

# Copy the built application from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
