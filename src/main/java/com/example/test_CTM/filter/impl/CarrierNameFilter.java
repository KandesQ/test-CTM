package com.example.test_CTM.filter.impl;

import com.example.test_CTM.dto.TicketFilterDto;
import com.example.test_CTM.filter.Filter;
import com.test_CTM.jooq.generated.tables.records.TicketsRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.exception.TooManyRowsException;
import org.springframework.stereotype.Component;

import static com.test_CTM.jooq.generated.Tables.TICKETS;
import static com.test_CTM.jooq.generated.Tables.CARRIERS;


@Component
@RequiredArgsConstructor
public class CarrierNameFilter implements Filter {

    private final DSLContext dsl;

    @Override
    public boolean isApplicable(TicketFilterDto ticketFilterDto) {
        return ticketFilterDto.getCarrierName() != null;
    }

    @Override
    public boolean apply(TicketFilterDto ticketFilterDto, TicketsRecord record) {

        String carrierName;

        try {
            carrierName = dsl
                    .select(CARRIERS.NAME)
                    .from(TICKETS)
                    .join(CARRIERS)
                    .on(TICKETS.CARRIER_ID.eq(CARRIERS.ID))
                    .where(TICKETS.ID.eq(record.getId()))
                    .fetchOne()
                    .getValue(CARRIERS.NAME);
        } catch (TooManyRowsException e) {
            throw new RuntimeException("More than one record was found");
        } catch (NullPointerException e) {
            throw new RuntimeException("No record was found");
        }

        return carrierName.equals(ticketFilterDto.getCarrierName());
    }
}
