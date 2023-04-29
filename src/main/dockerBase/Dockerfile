FROM openjdk:11-jre-slim

ENV JAVA_OPTS " -Xms512m -Xmx512m -Djava.security.egd=file:/dev/./urandom"

WORKDIR application

COPY ../../../target/spring-6-rest-mvc-0.0.1-SNAPSHOT.jar.original ./

ENTRYPOINT ["java", "-jar", "spring-6-rest-mvc-0.0.1-SNAPSHOT.jar.original"]
