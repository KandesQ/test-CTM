package com.example.test_CTM.service;

import com.example.test_CTM.dto.TicketDto;
import com.example.test_CTM.dto.TicketFilterDto;

import java.util.List;

public interface TicketService {

    /**
     * @return отфильтрованные, доступные к покупке билеты
     *
     * Пагинация - 20 штук
     */
    List<TicketDto> getFilteredAvailableTickets(TicketFilterDto ticketFilterDto);
}
