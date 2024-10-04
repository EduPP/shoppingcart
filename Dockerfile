FROM amazoncorretto:17-alpine as builder
WORKDIR /app

COPY ./pom.xml .
COPY ./.mvn ./.mvn
COPY ./mvnw .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline

COPY ./src ./src
RUN ./mvnw clean package -DskipTests

FROM amazoncorretto:17-alpine
WORKDIR /app
ARG TARGET_FOLDER=/app/target
COPY --from=builder $TARGET_FOLDER/store-demo-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "store-demo-0.0.1-SNAPSHOT.jar"]