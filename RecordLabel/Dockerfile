FROM openjdk:23-slim-bullseye
VOLUME /tmp
ADD ./target/RecordLabel-0.0.1-SNAPSHOT.jar recordLaabel.jar
ENTRYPOINT ["java","-jar","recordLaabel.jar"]
#CMD java -jar productos-ms.jar