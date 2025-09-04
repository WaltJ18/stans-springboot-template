# ====== Build Stage ======
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy Maven settings for Nexus
COPY ../setting.xml /root/.m2/settings.xml

# 1️⃣ Copy only POMs for caching dependencies
COPY ../pom.xml .
COPY ../client/pom.xml client/
COPY ../command/pom.xml command/
COPY ../domain-client/pom.xml domain-client/
COPY ../domain-command/pom.xml domain-command/
COPY ../entity/pom.xml entity/
COPY ../domain-web/pom.xml domain-web/
COPY ../exception/pom.xml exception/
COPY ../redis/pom.xml redis/
COPY ../repository/pom.xml repository/
COPY ../web/pom.xml web/

# 2️⃣ Download dependencies (cached unless POM changes)
RUN mvn dependency:go-offline -B -s /root/.m2/settings.xml

# 3️⃣ Copy full source code
COPY .. .

# 4️⃣ Build the application (skip tests for speed)
RUN mvn clean package -DskipTests

# ====== Runtime Stage ======
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Optional: set memory limits
ENV JAVA_OPTS="-Xms128m -Xmx256m"

# 5️⃣ Copy only the final boot JAR (web module is the final app)
COPY --from=builder /app/web/target/web-*.jar app.jar

# 6️⃣ Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
