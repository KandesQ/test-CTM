package com.example.test_CTM.controller.impl;

import com.example.test_CTM.controller.UserController;
import com.example.test_CTM.dto.TicketDto;
import com.example.test_CTM.dto.UserDto;
import com.example.test_CTM.service.UserService;
import com.test_CTM.jooq.generated.tables.records.TicketsRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Primary
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @PostMapping("/register_user")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.registerUser(userDto));
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<TicketDto>> getBoughtTickets(@RequestBody UserDto userDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUserTickets(userDto));
    }
}
