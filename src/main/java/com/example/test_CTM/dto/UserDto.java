package com.example.test_CTM.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {
    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // чтобы при сериализации не маппился
    private String password;

    private String firstName;

    private String MiddleName;

    private String LastName;
}
