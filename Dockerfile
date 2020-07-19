FROM openjdk:8-jdk
ADD demo-spring-boot-0.0.1-SNAPSHOT.jar demo-spring-boot-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "demo-spring-boot-0.0.1-SNAPSHOT.jar"]