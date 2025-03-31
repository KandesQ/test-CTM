package com.example.test_CTM.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Для получения и отправки на клиент использую один Dto.
 * Чтобы spring не отдавал пользователю дто с паролем - вешаю json property.
 * При сериализации (из Java в JSON) дто jackson не смапит пароль, а при десериализации (в Java) пароль успешно
 * смаппится
 */
@Data
public class UserDto {
    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String firstName;

    private String middleName;

    private String lastName;
}
