package dev.ghlima.demokafka.spring.producer;


import java.time.LocalDateTime;
import java.util.UUID;

public record CarRental(
        UUID rentalId,
        long customerId,
        UUID vehicleId,
        LocalDateTime rentalStart
) {}
