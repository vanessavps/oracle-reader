#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn package -DskipTests=true -P dev

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /app/target/oraclereader-0.0.1-SNAPSHOT.jar /usr/local/lib/oraclereader.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/oraclereader.jar"]