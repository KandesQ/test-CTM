package com.example.test_CTM.controller.impl;

import com.example.test_CTM.controller.TicketController;
import com.example.test_CTM.dto.TicketDto;
import com.example.test_CTM.dto.TicketFilterDto;
import com.example.test_CTM.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Primary
@RequiredArgsConstructor
@RequestMapping("/api/v1/tickets")
public class TicketControllerImpl implements TicketController {
    private final TicketService ticketService;

    @GetMapping("/available")
    public ResponseEntity<List<TicketDto>> getAvailableTickets(
            @RequestBody TicketFilterDto ticketFilterDto,
            @RequestParam int page,
            @RequestParam int pageSize)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ticketService.getFilteredAvailableTickets(ticketFilterDto, page, pageSize));
    }
}
