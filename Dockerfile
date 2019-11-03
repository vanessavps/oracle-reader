#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml  -DskipTests=true install -P dev

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /app/target/oraclereader-0.0.1-SNAPSHOT.jar /usr/local/lib/oraclereader.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/oraclereader.jar"]