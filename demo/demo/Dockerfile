# Etapa 1: Construcción
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Establecer directorio de trabajo
WORKDIR /app

# Copiar archivos de configuración de Maven
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY mvnw.cmd .

# Copiar código fuente
COPY src ./src

# Compilar la aplicación (sin ejecutar tests)
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Etapa 2: Ejecución
FROM eclipse-temurin:17-jre-alpine

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el JAR desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto (Render usará la variable PORT)
EXPOSE ${PORT:-8080}

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
