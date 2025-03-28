--liquibase formatted sql

-- создание таблиц

--changeset fedor:1
CREATE TABLE users
(
    id          SERIAL PRIMARY KEY,
    login       VARCHAR(100) NOT NULL UNIQUE,
    password    VARCHAR(255) NOT NULL,
    first_name  VARCHAR(100) NOT NULL,
    middle_name VARCHAR(100), -- middle_name это отчество
    last_name   VARCHAR(100)
);

--changeset fedor:2
CREATE TABLE carriers
(
    id    SERIAL PRIMARY KEY,
    phone VARCHAR(20), -- в инете смотрел, по международному стандарту макисмум 15 символов
    name  VARCHAR(100)
);

--changeset fedor:3
CREATE TABLE routes
(
    id     SERIAL PRIMARY KEY,
    "from" VARCHAR(100), -- квоты чтобы не было конфликтов с sql
    "to"   VARCHAR(100)
);

--changeset fedor:4
CREATE TABLE tickets
(
    id SERIAL PRIMARY KEY,
    user_id INT,
    carrier_id INT NOT NULL REFERENCES carriers(id),
    route_id INT NOT NULL REFERENCES routes(id),
    departure_at TIMESTAMP NOT NULL,
    arrive_at TIMESTAMP, -- время прибытия может быть неопределено
    seat_number INT NOT NULL,
    price NUMERIC(7, 2) NOT NULL, -- обычно что-то типа 1199,99 RUB, макс цена билета - 1 млн.

    -- если билет стоит в null, значит он продается, если есть user_id - он уже куплен
    -- если юзер купил билет и решил удалить акк, то билет просто становиться доступен к покупке другим юзерам
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);
