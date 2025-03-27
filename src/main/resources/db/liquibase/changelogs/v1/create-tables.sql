--liquibase formatted sql

-- создание таблиц

--changeset fedor:1
CREATE TABLE man (
    id SERIAL PRIMARY KEY ,
    name VARCHAR(255)
);

