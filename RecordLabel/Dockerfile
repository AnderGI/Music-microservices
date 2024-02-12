FROM openjdk:23-slim-bullseye
VOLUME /tmp
ADD ./target/RecordLabel-0.0.1-SNAPSHOT.jar recordlabel.jar
ENTRYPOINT ["java","-jar","recordlabel.jar"]
#CMD java -jar productos-ms.jar