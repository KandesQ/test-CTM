package com.example.test_CTM.repository;

import com.example.test_CTM.dto.UserDto;
import org.jooq.Record;
import org.jooq.Result;

import java.util.Optional;

/**
 * Методы возвращают числа - полезно будет в будущем. При дебаге
 * можно понять, если метод возвращает число но ошибка есть, значит хоть одна строка сохраняется в таблицу
 * и это сужает область проблемы.
 */
public interface UserRepository {

    /**
     * Сохраняет пользователя в базу, имя должно быть уникально
     */
    int save(UserDto userDto);

    boolean existByLogin(String login);

    Result<Record> getUserTickets(String login);


}
