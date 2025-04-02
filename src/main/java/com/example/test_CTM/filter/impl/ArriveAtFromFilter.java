package com.example.test_CTM.filter.impl;

import com.example.test_CTM.dto.TicketFilterDto;
import com.example.test_CTM.filter.Filter;
import com.test_CTM.jooq.generated.tables.records.TicketsRecord;
import org.springframework.stereotype.Component;

@Component
public class ArriveAtFromFilter implements Filter {
    @Override
    public boolean isApplicable(TicketFilterDto ticketFilterDto) {
        return ticketFilterDto.getArriveAtFrom() != null;
    }

    @Override
    public boolean apply(TicketFilterDto ticketFilterDto, TicketsRecord record) {
        return record.getArriveAt().isEqual(ticketFilterDto.getArriveAtFrom()) ||
                record.getArriveAt().isAfter(ticketFilterDto.getArriveAtFrom());
    }
}
