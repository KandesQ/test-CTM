package com.example.test_CTM.controller;

import com.example.test_CTM.dto.TicketDto;
import com.example.test_CTM.dto.TicketFilterDto;
import com.example.test_CTM.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TicketController {

    /**
     * @param ticketFilterDto пользовательские фильтры
     * @param page нужная страница, query param
     * @param pageSize кол-во билетов не странице, query param
     * @return дто доступных билетов
     */
    ResponseEntity<List<TicketDto>> getAvailableTickets(TicketFilterDto ticketFilterDto, int page, int pageSize);

    /**
     *
     * @param login покупающий пользователь
     * @param ticketDto информация о билете который надо купить
     * @return Оповощение об успешной покупке
     */
    ResponseEntity<String> buyTicket(String login, TicketDto ticketDto);
}
