FROM adoptopenjdk/openjdk11
MAINTAINER Igor Rodionov <iv.rodionov@gmail.com>
ARG JAR_FILE=target/crud-service-1.0.0-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 1234