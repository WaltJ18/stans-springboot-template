# ====== Build Stage ======
FROM maven:3.9.6-eclipse-temurin-21 AS deps
WORKDIR /app

# 1️⃣ Copy custom Maven settings (point to Nexus)
COPY ../setting.xml /root/.m2/settings.xml

# 2️⃣ Copy only pom.xml files first (for dependency cache)
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

# 3️⃣ Pre-fetch dependencies via Nexus
RUN mvn dependency:go-offline -B -s /root/.m2/settings.xml


# ===== Stage 2: Build =====
FROM ghcr.io/graalvm/native-image:21 AS builder
WORKDIR /app

# Install basic tools + Maven
RUN microdnf install -y tar gzip curl bash findutils \
    && curl -fsSL https://downloads.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz \
    | tar -xz -C /opt \
    && ln -s /opt/apache-maven-3.9.6/bin/mvn /usr/bin/mvn \
    && microdnf clean all


# 4️⃣ Copy Maven repo from deps stage to avoid redownloading
COPY --from=deps /root/.m2 /root/.m2

# 5️⃣ Copy full source
COPY .. .

# 6️⃣ Build native binary (Spring Boot 3+ supports -Pnative)
RUN mvn -Pnative native:compile -DskipTests -s /root/.m2/settings.xml


# ===== Stage 3: Runtime ====
FROM alpine:3.19
WORKDIR /app
RUN apk add --no-cache libc6-compat

COPY --from=builder /app/web/target/web /app/app
EXPOSE 8800
ENTRYPOINT ["./app"]
