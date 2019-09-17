mvn -Dtest=GenerateSwagger -Dtest-profile=GenerateSwagger test &&
java -jar swagger-codegen-cli-2.4.8.jar generate -i swagger.json -l typescript-angular -o angular