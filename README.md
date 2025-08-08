# Mortgage Portal API

A Spring Boot–based RESTful API for managing mortgage applications. It includes data persistence (PostgreSQL), optional Kafka integration, and auto-generated Swagger documentation for easy API testing and integration.

---

## Features

- Spring Boot application with dynamic port binding (`server.port=${PORT:8080}`)
- Secured PostgreSQL integration
- Optional Kafka integration for messaging (enabled via `KAFKA_ENABLED=true`)
- Swagger UI and OpenAPI documentation (`/swagger-ui.html`, `/api-docs`)
- Simple health endpoint (e.g. `/`)
- Docker Compose setup for local development (includes Kafka and Zookeeper)

---

## Getting Started

### Prerequisites

- Java 17+ (or your supported version)
- Maven
- Docker (for running Kafka and Zookeeper via `docker-compose`)
- PostgreSQL (or Neon, as configured in `application.properties`)
- Render account (if deploying)

---

## How to Build & Run

### **Locally (without Docker)**
1. Clone the repository:
   ```bash
   git clone https://github.com/OgadaMoses/mortgage-portal-api.git
   cd mortgage-portal-api
