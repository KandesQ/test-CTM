package com.example.test_CTM.repository.impl;

import com.example.test_CTM.dto.UserDto;
import com.example.test_CTM.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.*;
import org.jooq.Record;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import static com.test_CTM.jooq.generated.Tables.TICKETS;
import static com.test_CTM.jooq.generated.Tables.USERS;

@Repository("user_repository") // если надо через qualifier достать реализацию
@Primary // по дефолту спринг будет ее использовать
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final DSLContext dsl;

    @Override
    public int save(UserDto userDto) {
        return dsl
                .insertInto(USERS)
                .set(USERS.LOGIN, userDto.getLogin())
                .set(USERS.FIRST_NAME, userDto.getFirstName())
                .set(USERS.MIDDLE_NAME, userDto.getMiddleName())
                .set(USERS.LAST_NAME, userDto.getLastName())
                .set(USERS.PASSWORD, userDto.getPassword())
                .execute();
    }

    @Override
    public boolean existByLogin(String login) {
        return dsl
                .fetchExists(dsl
                        .selectOne()
                        .from(USERS)
                        .where(USERS.LOGIN.eq(login)));
    }

    @Override
    public Result<Record> getUserTickets(String login) {
        return dsl
                .select()
                .from(USERS)
                .join(TICKETS)
                .on(USERS.ID.eq(TICKETS.USER_ID))
                .where(USERS.LOGIN.eq(login))
                .fetch();
    }
}
