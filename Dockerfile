# Step 1: Base Image
FROM openjdk:17-jdk-slim

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy the jar from target folder
COPY target/portal-api-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port your Spring Boot app runs on
EXPOSE 8080

# Step 5: Run the jar
ENTRYPOINT ["java","-jar","app.jar"]
