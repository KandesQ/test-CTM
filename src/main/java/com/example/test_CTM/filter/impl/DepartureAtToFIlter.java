package com.example.test_CTM.filter.impl;

import com.example.test_CTM.dto.TicketFilterDto;
import com.example.test_CTM.filter.Filter;
import com.test_CTM.jooq.generated.tables.records.TicketsRecord;
import org.springframework.stereotype.Component;

@Component
public class DepartureAtToFIlter implements Filter {
    @Override
    public boolean isApplicable(TicketFilterDto ticketFilterDto) {
        return ticketFilterDto.getDepartureAtTo() != null;
    }

    @Override
    public boolean apply(TicketFilterDto ticketFilterDto, TicketsRecord record) {
        return record.getDepartureAt().isEqual(ticketFilterDto.getDepartureAtTo()) ||
                record.getDepartureAt().isBefore(ticketFilterDto.getDepartureAtTo());
    }
}
