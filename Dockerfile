# # build stage
# FROM maven AS build
# COPY src $PWD/src
# COPY pom.xml $PWD
# # RUN mvn install
# RUN mvn clean install
  
# # production stage
# FROM openjdk:16-jdk-alpine
# VOLUME /tmp
# EXPOSE 3000
# COPY --from=build $PWD/target/EventMod-0.0.1-SNAPSHOT.jar app.jar
# ENTRYPOINT ["java", "-jar", "app.jar"] 

FROM maven:3.6.1-jdk-11-slim AS build
COPY src /workspace/src
COPY pom.xml /workspace
WORKDIR /workspace
RUN mvn clean package

FROM openjdk:11.0-slim
EXPOSE 3000
COPY --from=build /workspace/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]