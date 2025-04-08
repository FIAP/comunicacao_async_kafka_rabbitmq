package dev.ghlima.demorabbitmq.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import dev.ghlima.demorabbitmq.dto.CancellationReservationDTO;
import dev.ghlima.demorabbitmq.dto.NewReservationDTO;
import dev.ghlima.demorabbitmq.service.ReservationPublisherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {

    private final ReservationPublisherService reservationPublisherService;

    @PostMapping("/new")
    public ResponseEntity<String> newReservation(@RequestBody NewReservationDTO reservation) throws JsonProcessingException {
        reservationPublisherService.sendNewReservation(reservation);
        return ResponseEntity.ok("New reservation sent!");
    }

    @PostMapping("/cancel")
    public ResponseEntity<String> cancelReservation(@RequestBody CancellationReservationDTO reservation) {
        reservationPublisherService.sendCancellationReservation(reservation);
        return ResponseEntity.ok("Reservation cancellation sent!");
    }
}
