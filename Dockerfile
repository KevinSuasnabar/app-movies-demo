FROM openjdk:17-jdk-alpine as builder

WORKDIR /app

COPY ./pom.xml /app
COPY ./.mvn ./.mvn
COPY ./mvnw .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./src ./src/

RUN ./mvnw clean package -DskipTests


FROM openjdk:17-jdk-alpine

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/target/movies-app-0.0.1-SNAPSHOT.jar .

ARG PORT_APP=8040
ENV PORT $PORT_APP

EXPOSE $PORT

CMD ["java", "-jar", "movies-app-0.0.1-SNAPSHOT.jar"]