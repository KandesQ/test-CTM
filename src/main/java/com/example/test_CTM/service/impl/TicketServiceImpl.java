package com.example.test_CTM.service.impl;

import com.example.test_CTM.dto.TicketDto;
import com.example.test_CTM.dto.TicketFilterDto;
import com.example.test_CTM.filter.Filter;
import com.example.test_CTM.repository.TicketRepository;
import com.example.test_CTM.service.TicketService;
import com.test_CTM.jooq.generated.tables.records.TicketsRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.awt.geom.AffineTransform;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final List<Filter> ticketFilters;
    private final TicketRepository ticketRepository;


    @Override
    public List<TicketDto> getFilteredAvailableTickets(TicketFilterDto ticketFilterDto, int page, int pageSize) {
        return ticketRepository.getTickets(page, pageSize).stream()
                .filter(ticketRecord -> filterTicket(ticketFilterDto, ticketRecord))
                .map(TicketDto::recordToDto)
                .toList();
    }

    /**
     * @param ticketFilterDto пользовательские фильтры
     * @param ticketRecord билет
     * @return прошел ли билет фильтрацию пользователя
     *
     * Если хотя бы один приминимый фильтр не пройден, то вернет false
     *
     * прошел фильтр - true, иначе - false
     *
     */
    private boolean filterTicket(TicketFilterDto ticketFilterDto, TicketsRecord ticketRecord) {
        for (Filter ticketFilter: ticketFilters) {
            if (ticketFilter.isApplicable(ticketFilterDto)) {
                if (!ticketFilter.apply(ticketFilterDto, ticketRecord)) {
                    return false;
                }
            }
        }
        return true;
    }
}
