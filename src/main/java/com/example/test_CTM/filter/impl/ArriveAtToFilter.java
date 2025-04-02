package com.example.test_CTM.filter.impl;

import com.example.test_CTM.dto.TicketFilterDto;
import com.example.test_CTM.filter.Filter;
import com.test_CTM.jooq.generated.tables.records.TicketsRecord;
import org.springframework.stereotype.Component;

@Component
public class ArriveAtToFilter implements Filter {
    @Override
    public boolean isApplicable(TicketFilterDto ticketFilterDto) {
        return ticketFilterDto.getArriveAtTo() != null;
    }

    @Override
    public boolean apply(TicketFilterDto ticketFilterDto, TicketsRecord record) {
        return record.getArriveAt().isEqual(ticketFilterDto.getArriveAtTo()) ||
                record.getArriveAt().isBefore(ticketFilterDto.getArriveAtTo());
    }
}
