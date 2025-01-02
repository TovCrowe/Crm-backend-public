FROM gradle:7-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -x test

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /home/gradle/src/build/libs/*.jar vet.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "vet.jar"]