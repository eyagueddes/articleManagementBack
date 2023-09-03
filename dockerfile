# Java 11
FROM openjdk:11
# Refer to Maven build -> finalName
ARG JAR_FILE=target/management.jar

# cd /app //dossier de travail dans container
WORKDIR /app

# cp target/management.jar /app/app.jar //renommer
COPY ${JAR_FILE} app.jar

# java -jar /app/app.jar // exécuter java -jar
ENTRYPOINT ["java","-jar","app.jar"]

