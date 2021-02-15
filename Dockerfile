# Start with a base image containing Java runtime 
FROM openjdk:11-jre-slim

# The application's jar file 
ARG JAR_FILE=./build/libs/utility-*.jar
COPY ${JAR_FILE} utility.jar
ENTRYPOINT ["java","-jar","/utility.jar"]