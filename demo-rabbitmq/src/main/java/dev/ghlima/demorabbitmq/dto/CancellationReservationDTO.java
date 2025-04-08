package dev.ghlima.demorabbitmq.dto;

import lombok.Data;

@Data
public class CancellationReservationDTO {
    private String reservationId;
    private String clientName;
    private String reason;
}
