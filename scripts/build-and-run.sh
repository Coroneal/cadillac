#!/bin/sh
cd ..
./mvnw clean install -DskipTests && java -jar target/cadillac-0.0.1-SNAPSHOT.jar