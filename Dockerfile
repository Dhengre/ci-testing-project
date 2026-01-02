FROM maven:3.9.6-eclipse-temurin-17

RUN apt-get update && \
    apt-get install -y chromium chromium-driver

ENV CHROME_BIN=/usr/bin/chromium

WORKDIR /app

COPY . .

CMD ["mvn", "clean", "test"]
