FROM openjdk:23-slim-bullseye
VOLUME /tmp
ADD ./target/Eureka-0.0.1-SNAPSHOT.jar eureka.jar
ENTRYPOINT ["java","-jar","eureka.jar"]
#CMD java -jar productos-ms.jar