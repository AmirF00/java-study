# Use the official OpenJDK base image with slim variant for better cross-platform support
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . .

# Compile the Java program
RUN javac Main.java

# Run the Java program
CMD ["java", "Main"]

