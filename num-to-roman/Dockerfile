# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Compile the Java program
RUN javac Main.java

# Define the command to run the program
CMD ["java", "Main"]

