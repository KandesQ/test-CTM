package com.example.test_CTM.filter.impl;

import com.example.test_CTM.dto.TicketFilterDto;
import com.example.test_CTM.filter.Filter;
import com.test_CTM.jooq.generated.tables.Routes;
import com.test_CTM.jooq.generated.tables.records.TicketsRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.exception.TooManyRowsException;
import org.springframework.stereotype.Component;


import static com.test_CTM.jooq.generated.Tables.TICKETS;
import static com.test_CTM.jooq.generated.Tables.ROUTES;


@Component
@RequiredArgsConstructor
public class FromPlaceFilter implements Filter {

    private final DSLContext dsl;

    @Override
    public boolean isApplicable(TicketFilterDto ticketFilterDto) {
        return ticketFilterDto.getFrom() != null;
    }

    @Override
    public boolean apply(TicketFilterDto ticketFilterDto, TicketsRecord record) {
        String from;

        try {
            // можно воспользоваться fetchOneInto, но для
            // проверки содержания данных в базе иду через getValue
            from = dsl
                    .select(ROUTES.FROM)
                    .from(TICKETS)
                    .join(ROUTES)
                    .on(TICKETS.ROUTE_ID.eq(ROUTES.ID))
                    .where(TICKETS.ID.eq(record.getId()))
                    .fetchOne()
                    .getValue(ROUTES.FROM);
        } catch (TooManyRowsException e) {
            // log.info("More than one record was found")
            throw new RuntimeException("More than one record was found");
        } catch (NullPointerException e) {
            // по логике программы, если нет маршрута, то это ошибка, поэтому без Optional
            // log.info("No record was found")
            throw new RuntimeException("No record was found");
        }

        return from.equals(ticketFilterDto.getFrom());
    }
}
