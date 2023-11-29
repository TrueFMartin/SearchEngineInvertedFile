#!/bin/bash

JAR_PATH="../target/query-api.jar"

nohup java -jar $JAR_PATH &

echo "Content-type: text/plain"
echo ""
echo "Spring Boot application started."
