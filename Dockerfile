FROM maven:3.9.6-eclipse-temurin-17

WORKDIR /automation

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
COPY testng.xml .

CMD ["mvn", "test"]
