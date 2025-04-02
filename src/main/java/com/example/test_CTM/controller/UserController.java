package com.example.test_CTM.controller;

import com.example.test_CTM.dto.TicketDto;
import com.example.test_CTM.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserController {
    ResponseEntity<String> registerUser(UserDto userDto);

    ResponseEntity<List<TicketDto>> getBoughtTickets(UserDto userDto);
}
