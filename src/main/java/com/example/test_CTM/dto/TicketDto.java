package com.example.test_CTM.dto;

import com.test_CTM.jooq.generated.tables.records.TicketsRecord;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketDto {
    private LocalDateTime departureAt;
    private LocalDateTime arriveAt;
    private int seat;
    private double price;


    public static TicketDto recordToDto(TicketsRecord record) {
        TicketDto dto = new TicketDto();

        dto.setDepartureAt(record.getDepartureAt());
        dto.setArriveAt(record.getArriveAt());
        dto.setSeat(record.getSeatNumber());
        dto.setPrice(record.getPrice());

        return dto;
    }
}
