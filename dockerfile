# Use Java 17
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN apt-get update && apt-get install -y maven
RUN mvn clean package

# Expose port
EXPOSE 8080

# Run the WAR file
CMD ["java", "-jar", "target/portfolio-backend.war"]
