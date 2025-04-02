package com.example.test_CTM.filter;

import com.example.test_CTM.dto.TicketFilterDto;
import com.test_CTM.jooq.generated.tables.records.TicketsRecord;

/**
 * Класс фильтра
 */
public interface Filter {

    /**
     * Проверяет, указан ли фильтр в пришедшем {@link TicketFilterDto}
     *
     * @param ticketFilterDto фильтр от пользователя
     * @return применим или нет
     */
    boolean isApplicable(TicketFilterDto ticketFilterDto);

    /**
     * Применяет фильтр если {@link Filter#isApplicable} выдал true
     *
     * @param ticketFilterDto фильтр от пользователя
     * @param record сущность билета
     * @return результат применения фильтра
     */
    boolean apply(TicketFilterDto ticketFilterDto, TicketsRecord record);
}
