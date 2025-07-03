# -------------------- Build Stage --------------------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY Military-Asset-Management/ ./Military-Asset-Management
WORKDIR /app/Military-Asset-Management
RUN mvn clean package -DskipTests

# -------------------- Runtime Stage --------------------
FROM openjdk:17-jdk-slim
VOLUME /tmp
ENV JAVA_OPTS=""

COPY --from=build /app/Military-Asset-Management/target/*.jar app.jar

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
