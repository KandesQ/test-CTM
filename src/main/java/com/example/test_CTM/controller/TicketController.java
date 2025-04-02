package com.example.test_CTM.controller;

import com.example.test_CTM.dto.TicketDto;
import com.example.test_CTM.dto.TicketFilterDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TicketController {

    /**
     * @param ticketFilterDto пользовательские фильтры
     * @param page нужная страница
     * @param pageSize кол-во билетов не странице
     * @return дто доступных билетов
     */
    ResponseEntity<List<TicketDto>> getAvailableTickets(TicketFilterDto ticketFilterDto, int page, int pageSize);
}
