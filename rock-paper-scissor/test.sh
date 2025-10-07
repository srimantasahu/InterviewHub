#!/bin/bash
# Run JUnit tests using Maven

echo "=== Running tests ==="
mvn test
if [ $? -ne 0 ]; then
    echo "Some tests failed!"
    exit 1
fi
echo "All tests passed!"
