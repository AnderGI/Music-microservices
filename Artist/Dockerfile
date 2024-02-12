FROM openjdk:23-slim-bullseye
VOLUME /tmp
ADD ./target/Artist-0.0.1-SNAPSHOT.jar artists.jar
ENTRYPOINT ["java","-jar","artists.jar"]
#CMD java -jar productos-ms.jar