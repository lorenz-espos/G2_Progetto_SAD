# Usa un'immagine di base con Java installato
FROM openjdk:17-jdk

# Copia il tuo JAR nel container
COPY t5-0.0.1-SNAPSHOT.jar /app/

# Copia il repository nel container
COPY FolderTree /app/

# Imposta la directory di lavoro all'interno del container
WORKDIR /app

# Comando di avvio dell'applicazione
CMD ["java", "-jar", "t5-0.0.1-SNAPSHOT.jar"]
