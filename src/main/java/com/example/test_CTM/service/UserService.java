package com.example.test_CTM.service;

import com.example.test_CTM.dto.UserDto;
import org.jooq.User;

import java.util.Optional;

/**
 * Формат ответа String
 */
public interface UserService {
    String registerUser(UserDto userDto);

//    Optional<Result<Record>> getAllBoughtTickets(UserDto userDto); что то такое
}
