FROM amazoncorretto:20-alpine-jdk

COPY ./target/jfood-api.jar /app/app.jar

WORKDIR /app

EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]
