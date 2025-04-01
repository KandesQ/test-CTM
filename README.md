# Test CTM-Labs

### Stack:
- Java 23
- Spring/Spring Boot Web
- Swagger
- Git/GitHub
- PostgreSQL
- JooQ
- Gradle
- Docker/docker-compose

## Начало работы

Для работы базы нужен Docker

У приложения 2 конфигурации:
- Приложение и база в докере
- Приложение в IDEA, база в докере

Чтобы запустить базу в докере, выполните
```bash
  docker compose up -d postgres
```

Чтобы запустить и базу и приложение:
```bash
  docker compose up -d
```