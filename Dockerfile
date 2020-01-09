FROM openjdk:8u111-jdk
MAINTAINER esteban.castano@ceiba.com.co
VOLUME /tmp
ADD configuration/build/libs/configuration-1.0.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
