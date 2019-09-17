#!/bin/bash
mvn -Dtest=GenerateSwagger -Dtest-profile=GenerateSwagger test && rm -rf angular &&
java -jar swagger-codegen-cli-2.4.8.jar generate -i swagger.json -l typescript-angular -o angular