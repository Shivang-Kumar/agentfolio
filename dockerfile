# ---------- Build Stage ----------
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

# ---------- Runtime Stage ----------
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy executable jar
COPY --from=builder /app/agent-api/target/agent-api-0.0.1-SNAPSHOT.jar app.jar

# Copy information folder
COPY information /information

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]