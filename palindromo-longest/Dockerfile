# Use the official OpenJDK image as base
FROM openjdk:11

# Set the working directory in the container
WORKDIR /app

# Copy Main.java to the working directory
COPY Main.java .

# Compile the Java program
RUN javac Main.java

# Run the Java program
CMD ["java", "Main"]

