package com.example.test_CTM.repository;

import com.example.test_CTM.dto.TicketDto;
import com.test_CTM.jooq.generated.tables.records.TicketsRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


public interface TicketRepository {
    /**
     *
     * @param page query параметр, номер страницы
     * @param pageSize query параметр, кол-во элементов
     * @return страница билетов
     */
    Result<TicketsRecord> getTickets(int page, int pageSize);

    TicketsRecord getTicket(TicketDto ticketDto);
}
