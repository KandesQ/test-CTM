package com.example.test_CTM.repository;

import com.example.test_CTM.dto.UserDto;
import com.test_CTM.jooq.generated.tables.records.TicketsRecord;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Result;

import java.util.Optional;

/**
 * Тк login пользователя уникален, по нему можно делать выборку и проверку на существование
 */
public interface UserRepository {

    /**
     * Сохраняет пользователя в базу, имя должно быть уникально
     */
    int save(UserDto userDto);

    boolean existByLogin(String login);

    /**
     * Выполняет JOIN таблиц users и tickets
     * Если билет не куплен, поле user_id выставлено в null
     *
     * @param login логин пользователя
     * @return все купленные билеты юзера
     */
    Result<TicketsRecord> getUserTickets(String login);
}
