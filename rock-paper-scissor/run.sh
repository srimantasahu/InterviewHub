#!/bin/bash
# Script to compile and run Rock-Paper-Scissors using Maven

JAR_FILE="target/rock-paper-scissors-1.0.0.jar"

# Check if JAR already exists
if [ -f "$JAR_FILE" ]; then
    echo "JAR found: $JAR_FILE"
else
    echo "JAR not found. Compiling and packaging..."
    mvn clean package
    if [ $? -ne 0 ]; then
        echo "Maven build failed!"
        exit 1
    fi
fi

echo "=== Running the game ==="
java -jar "$JAR_FILE"
