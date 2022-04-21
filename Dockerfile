FROM openjdk:8
EXPOSE 9090
ADD target/professors.jar professors.jar
ENTRYPOINT ["java","-jar","/professors.jar"]