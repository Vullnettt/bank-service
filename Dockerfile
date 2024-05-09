# Build stage
FROM gradle:7.6.1-jdk17 AS build
WORKDIR /app
COPY . /app
RUN gradle clean build --no-daemon

# Runtime stage
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/build/libs/email-service-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENV JAVA_OPS="-Xmx512m -Xms256m"

RUN groupadd -g 999 appuser && \
    useradd -r -u 999 -g appuser appuser

USER appuser

ENTRYPOINT ["java", "-jar", "/app/app.jar"]