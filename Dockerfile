# Usa la imagen base de Java
FROM openjdk:11-jre-slim

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el JAR construido de la aplicación Spring Boot al contenedor
COPY target/tu-aplicacion-spring-boot.jar /app/app.jar

# Expone el puerto 8080 en el contenedor
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot cuando se inicie el contenedor
CMD ["java", "-jar", "app.jar"]
