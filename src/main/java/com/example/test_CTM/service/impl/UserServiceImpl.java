package com.example.test_CTM.service.impl;

import com.example.test_CTM.dto.UserDto;
import com.example.test_CTM.repository.UserRepository;
import com.example.test_CTM.service.UserService;
import com.test_CTM.jooq.generated.tables.records.TicketsRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String registerUser(UserDto userDto) {

        if (userRepository.existByLogin(userDto.getLogin())) {
            throw new RuntimeException("User=" + userDto.getLogin() + " already exists");
        }

        userRepository.save(userDto);

        return "User successfully registered!";
    }

    @Override
    public Result<TicketsRecord> getUserTickets(UserDto userDto) {

        if (!userRepository.existByLogin(userDto.getLogin())) {
            throw new RuntimeException("User=" + userDto.getLogin() + " doesn't exists");
        }

        return userRepository.getUserTickets(userDto.getLogin());
    }

}
