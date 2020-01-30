FROM maven:3.5.2-jdk-8 AS MAVEN_BUILD

COPY . /build/
WORKDIR /build

RUN mvn clean install


FROM openjdk:8-jdk-alpine

WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/file-uploader.jar /app/

ENTRYPOINT [ "java","-jar","file-uploader.jar"]