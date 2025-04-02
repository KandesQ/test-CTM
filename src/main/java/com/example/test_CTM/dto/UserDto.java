package com.example.test_CTM.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * Для получения и отправки на клиент использую один Dto.
 * Чтобы spring не отдавал пользователю дто с паролем - вешаю json property.
 * При сериализации (из Java в JSON) дто jackson не смапит пароль, а при десериализации (в Java) пароль успешно
 * смаппится
 */
@Data
public class UserDto {

    @NotBlank(message = "login must be specified")
    @Size(min = 3, max = 100, message = "login size must contain at least 3 symbols. The max is 100")
    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "password must be specified")
    @Size(min = 10, max = 255, message = "password size must contain at least 10 symbols. The max is 255")
    private String password;

    private String firstName;

    private String middleName;

    private String lastName;
}
