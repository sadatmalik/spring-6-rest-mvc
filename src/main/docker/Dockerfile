FROM amazoncorretto:17 as builder
WORKDIR application
ADD maven/spring-6-rest-mvc-0.0.1-SNAPSHOT.jar ./
RUN java -Djarmode=layertools -jar spring-6-rest-mvc-0.0.1-SNAPSHOT.jar extract

FROM amazoncorretto:17
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "org.springframework.boot.loader.JarLauncher"]