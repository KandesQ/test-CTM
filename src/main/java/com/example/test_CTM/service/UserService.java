package com.example.test_CTM.service;

import com.example.test_CTM.dto.UserDto;
import com.test_CTM.jooq.generated.tables.records.TicketsRecord;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Result;

import java.util.Optional;

public interface UserService {

    String registerUser(UserDto userDto);
    /**
     * Возвращает все купленные юзером билеты
     */
    Result<TicketsRecord> getUserTickets(UserDto userDto);
}
