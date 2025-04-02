package com.example.test_CTM.service.impl;

import com.example.test_CTM.dto.TicketDto;
import com.example.test_CTM.dto.TicketFilterDto;
import com.example.test_CTM.filter.Filter;
import com.example.test_CTM.repository.TicketRepository;
import com.example.test_CTM.repository.UserRepository;
import com.example.test_CTM.service.TicketService;
import com.test_CTM.jooq.generated.tables.records.TicketsRecord;
import com.test_CTM.jooq.generated.tables.records.UsersRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;
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
    private final UserRepository userRepository;
    private final ThreadPoolTaskExecutorBuilder threadPoolTaskExecutorBuilder;


    @Override
    public List<TicketDto> getFilteredAvailableTickets(TicketFilterDto ticketFilterDto, int page, int pageSize) {
        return ticketRepository.getTickets(page, pageSize).stream()
                .filter(ticketRecord -> filterTicket(ticketFilterDto, ticketRecord))
                .map(TicketDto::recordToDto)
                .toList();
    }

    @Override
    public String buyTicket(String login, TicketDto ticketDto) {
        // проверка есть ли пользователь
        // проверка есть ли билет
        // проверка доступен ли билет
        // привязка билета к пользователю

        if (!userRepository.existByLogin(login)) {
            throw new RuntimeException("User=" + login + " doesn't exist");
        }

        if (ticketRepository.getTicket(ticketDto) == null) {
            throw new RuntimeException("Specified ticket doesn't exist");
        }

        if (ticketRepository.getTicket(ticketDto).getUserId() != null) {
            throw new RuntimeException("The ticket is already bought");
        }

        ticketRepository.getTicket(ticketDto)
                .setUserId(userRepository.getUserByLogin(login).getId());

        return "Ticket successfully bought";
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
