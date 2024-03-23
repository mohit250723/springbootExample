#Defining base docker image
FROM openjdk:11
LABEL maintainer="javawithdockerbymohit.net"
ADD target/springbootExample-0.0.1-SNAPSHOT.jar springbootcrud-docker.jar
ENTRYPOINT ["java","-jar","springbootcrud-docker.jar"]