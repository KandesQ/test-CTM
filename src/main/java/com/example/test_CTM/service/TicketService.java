package com.example.test_CTM.service;

import com.example.test_CTM.dto.TicketDto;
import com.example.test_CTM.dto.TicketFilterDto;

import java.util.List;

public interface TicketService {

    /**
     * @return отфильтрованные, доступные к покупке билеты с возможностью пагинации
     */
    List<TicketDto> getFilteredAvailableTickets(TicketFilterDto ticketFilterDto, int page, int pageSize);

    /**
     *
     * @param login покупающий пользователь
     * @param ticketDto информация о билете который надо купить
     * @return Оповощение об успешной покупке
     */
    String buyTicket(String login, TicketDto ticketDto);
}
