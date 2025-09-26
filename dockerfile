# Step 1: Use official JDK as base image
FROM openjdk:17-jdk

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy the jar file into container
COPY target/calculator-web-1.0.0.jar app.jar

# Step 4: Expose port
EXPOSE 8080

# Step 5: Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]