package com.example.test_CTM.service.impl;

import com.example.test_CTM.dto.UserDto;
import com.example.test_CTM.repository.UserRepository;
import com.example.test_CTM.service.UserService;
import lombok.RequiredArgsConstructor;
import org.jooq.Record;
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
}
