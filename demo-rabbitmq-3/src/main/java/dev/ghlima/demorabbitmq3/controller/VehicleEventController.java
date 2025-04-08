package dev.ghlima.demorabbitmq3.controller;

import dev.ghlima.demorabbitmq3.dto.VehicleEventDTO;
import dev.ghlima.demorabbitmq3.service.VehicleEventPublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class VehicleEventController {

    private final VehicleEventPublisherService eventPublisher;

    public VehicleEventController(VehicleEventPublisherService eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEvent(@RequestBody VehicleEventDTO event) {
        String routingKey = "veiculo." + event.vehicleType().toLowerCase() + "." + event.eventAction().toLowerCase();
        eventPublisher.publishEvent(event, routingKey);
        return ResponseEntity.ok("Event published with routing key: " + routingKey);
    }
}
