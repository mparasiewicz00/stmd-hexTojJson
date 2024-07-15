#!/bin/bash

set -e

APP_NAME="stmd-hexTojJson"
JAR_FILE="target/${APP_NAME}-0.0.1-SNAPSHOT.jar"

if [ ! -f "$JAR_FILE" ]; then
  echo "Plik $JAR_FILE nie istnieje. Budowanie projektu Mavenem..."
  mvn clean package
fi

if [ ! -f "$JAR_FILE" ]; then
  echo "Plik $JAR_FILE nie został utworzony. Sprawdź logi Maven pod kątem błędów."
  exit 1
fi

sleep 2

echo "Budowanie obrazu Dockera..."
docker compose build

echo "Uruchamianie kontenerów..."
docker compose up -d

echo "Aplikacja ${APP_NAME} jest uruchomiona i dostępna na porcie 8080."