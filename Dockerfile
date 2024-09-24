FROM openjdk:17-jdk-slim
ARG JAR_FILE=./api/build/libs/api-0.0.1.jar
COPY ${JAR_FILE} ida-api.jar
ENV TZ=Asia/Seoul
CMD ["java", "-jar", "ida-api.jar"]