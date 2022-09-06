# build stage
FROM maven AS build
COPY src $PWD/src
COPY pom.xml $PWD
RUN sudo mvn clean package
  
# production stage
FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
EXPOSE 3000
COPY --from=build $PWD/target/Eventmod-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"] 