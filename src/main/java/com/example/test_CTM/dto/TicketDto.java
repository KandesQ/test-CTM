package com.example.test_CTM.dto;

import com.test_CTM.jooq.generated.tables.records.TicketsRecord;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketDto {

    @Future(message = "the departure date must be in future")
    private LocalDateTime departureAt;

    @Future(message = "the arrive date must be in future")
    private LocalDateTime arriveAt;

    @NotNull(message = "seat number must be specified")
    private int seat;

    @NotNull(message = "price must be specified")
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
