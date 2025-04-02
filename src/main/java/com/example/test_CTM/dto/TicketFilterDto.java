package com.example.test_CTM.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Набор фильтров, которые надо применить. Приходит от пользователя
 *
 * Если поле null - значит юзер не указал фильтр
 */
@Data
public class TicketFilterDto {

    // границы времени отправки и прибытия
    private LocalDateTime departureAtFrom;
    private LocalDateTime departureAtTo;
    private LocalDateTime arriveAtFrom;
    private LocalDateTime arriveAtTo;

    private String from;
    private String to;
    private String carrierName;
}
