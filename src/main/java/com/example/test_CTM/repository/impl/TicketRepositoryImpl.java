package com.example.test_CTM.repository.impl;

import com.example.test_CTM.dto.TicketDto;
import com.example.test_CTM.repository.TicketRepository;
import com.test_CTM.jooq.generated.tables.records.TicketsRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.exception.TooManyRowsException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

import static com.test_CTM.jooq.generated.Tables.TICKETS;

@Repository
@Primary
@RequiredArgsConstructor
public class TicketRepositoryImpl implements TicketRepository {
    private final DSLContext dsl;


    @Override
    public Result<TicketsRecord> getTickets(int page, int pageSize) {
        // чтобы избежать повторений и, при изменении данных в базе, пропусков строк, надо сделать сортировку
        return dsl
                .select()
                .from(TICKETS)
                .orderBy(TICKETS.ID.asc())
                .limit(pageSize)
                .offset((page - 1) * pageSize)
                .fetchInto(TICKETS);
    }

    @Override
    public TicketsRecord getTicket(TicketDto ticketDto) {
        try {
            return dsl
                    .selectFrom(TICKETS)
                    .where(TICKETS.DEPARTURE_AT.eq(ticketDto.getDepartureAt()))
                    .and(TICKETS.ARRIVE_AT.eq(ticketDto.getArriveAt()))
                    .and(TICKETS.SEAT_NUMBER.eq(ticketDto.getSeat()))
                    .and(TICKETS.PRICE.eq(BigDecimal.valueOf(ticketDto.getPrice())))
                    .fetchOne();
        } catch (TooManyRowsException e) {
            throw new RuntimeException("Found more than one row:");
            // log.info(e.getMessage) ...

        }
    }
}
