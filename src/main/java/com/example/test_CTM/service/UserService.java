package com.example.test_CTM.service;

import com.example.test_CTM.dto.UserDto;
import org.jooq.User;

import java.util.Optional;

/**
 * методы возвращают Optional объекты
 *
 * Если операция завершилась с ошибкой (валидация в сервисе не прошла, например),
 * то возвращается Optional.empty(), если все ок - Optional.of(userDto).
 * Это нужно, чтобы контроллер мог отправить ошибку, почему не получилось выполнить операцию
 *
 */
public interface UserService {
    Optional<UserDto> registerUser(UserDto userDto);

    Optional<UserDto> getAllBoughtTickets(UserDto userDto);
}
