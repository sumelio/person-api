FROM openjdk:8-jdk-alpine
COPY /build/libs/person-0.0.1-SNAPSHOT.jar person-0.0.1-SNAPSHOT.jar
COPY startup.sh startup.sh
RUN chmod 755 startup.sh
ENTRYPOINT sh startup.sh
