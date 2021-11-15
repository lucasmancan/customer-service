FROM gradle:7.3.0-jdk11 as build
WORKDIR /customer-service
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle
COPY src src
COPY conf conf
RUN gradle shadowJar


FROM adoptopenjdk/openjdk11-openj9:ubi-minimal
ENV AB_ENABLED=jmx_exporter
RUN mkdir /opt/shareclasses
RUN chmod a+rwx -R /opt/shareclasses
RUN mkdir /opt/app
COPY --from=build /customer-service/build/libs/customer-service-1.0.0-all.jar app.jar

CMD ["java", "-XX:+IdleTuningGcOnIdle", "-Xtune:virtualized", "-Xshareclasses:cacheDir=/opt/shareclasses", "-jar", "app.jar"]