package dev.ghlima.demorabbitmq.dto;

import lombok.Data;


@Data
    public class NewReservationDTO {
        private String reservationId;
        private String clientName;
        private String vehicleId;
    }
