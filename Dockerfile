FROM amazoncorretto:11
VOLUME /tmp
ADD build/libs/recipeproject-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar", "--spring.config.location=file:src/main/resources/application.properties"]