FROM openjdk:17-jdk-alpine3.13
VOLUME /tmp
ADD target/*.jar app.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/app.jar"]