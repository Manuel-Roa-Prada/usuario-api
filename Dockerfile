# Etapa 1: Construcción del proyecto
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final liviana para producción
FROM eclipse-temurin:21
WORKDIR /app
COPY --from=build /app/target/usuario-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
