FROM openjdk:8
COPY /target/spl.jar spl.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "spl.jar"]