FROM gradle:7.3.0-jdk8 as build
WORKDIR /customer-service
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle
COPY src src
COPY conf conf
RUN gradle shadowJar

FROM openjdk:8-jdk-slim
WORKDIR /customer-service
COPY --from=build /customer-service/build/libs/customer-service-1.0.0-all.jar app.jar
COPY conf conf
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
