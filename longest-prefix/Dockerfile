# Use the official OpenJDK image for Java 8
FROM openjdk:8

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the current directory contents into the container
COPY . .

# Compile the Java program
RUN javac Main.java

# Run the program when the container launches
CMD ["java", "Main"]

