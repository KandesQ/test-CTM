# Test CTM-Labs

## Stack:
- Java 23
- Spring/Spring Boot Web
- Swagger
- Git/GitHub
- PostgreSQL
- JooQ
- Gradle
- Docker/docker-compose

Swagger по ссылке http://localhost:8080/swagger-ui

## О реализации
Реализовал код в паттерне MVC. Не все методы вошли в репозиторий,
для некоторых фильтров пришлось делать ручные запросы. Их
также делал через dsl жука.

Для контроллера пользователей использовал одну дто, исключив
при сериализации поле с паролем через Jackson JSONproperty.


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
