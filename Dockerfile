FROM openjdk:17
WORKDIR /appContainer
COPY /.target/spring-boot-jenkins.jar /appContainer
EXPOSE 8282
CMD ["java","-jar","spring-boot-jenkins.jar"]