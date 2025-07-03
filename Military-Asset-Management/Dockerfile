# -------------------- Build Stage --------------------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# -------------------- Runtime Stage --------------------
FROM openjdk:17-jdk-slim
VOLUME /tmp
ENV JAVA_OPTS=""

# Copy the JAR built in the previous stage
COPY --from=build /app/target/*.jar app.jar

# Run the JAR
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
