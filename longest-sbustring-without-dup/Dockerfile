# Use the official OpenJDK image with JRE and JDK installed
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /usr/src/app

# Copy the Main.java file into the container
COPY Main.java .

# Compile the Java program
RUN javac Main.java

# Run the compiled Java program
CMD ["java", "Main"]

