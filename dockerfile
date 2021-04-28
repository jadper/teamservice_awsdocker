FROM openjdk:11-jdk-slim-buster
COPY ./target/teamservice-0.0.1-SNAPSHOT.jar /usr/app/teamservice.jar
WORKDIR /usr/app
EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "teamservice.jar" ]
