# Customer Management Service - Docker Basic Asssignment

## Project Overview
This is a Spring Boot Customer Management application with PostgreSQL database. The application is containerized using Docker and cab be run using Docker and Docker Compose.

## Tech Stack
- Java 17
- Spring Boot
- PostgreSQL
- Docker
- Docker Compose

  ## Prerequisites
  Install these before running the project:
  - Java 17
  - Maven
  - Docker
  - Docker Compose
 
## Build the application
  bash: mvn clean package

## Run using docker compose 
  docker compose up -d --build 
  docker compose ps
  docker compose logs app

## Access application 
http://localhost:8080/index.html

## Run Manually 
docker run -d -p 8080:8080 --name docker-basic-assignment-container docker-basic-assignment-app
