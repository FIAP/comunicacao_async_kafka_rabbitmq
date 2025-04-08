package dev.ghlima.demorabbitmq2.controller;

import dev.ghlima.demorabbitmq2.dto.NotificationDTO;
import dev.ghlima.demorabbitmq2.service.NotificationPublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationPublisherService notificationPublisher;

    NotificationController(NotificationPublisherService notificationPublisher) {
        this.notificationPublisher = notificationPublisher;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationDTO message) {
        notificationPublisher.sendNotification(message);
        return ResponseEntity.ok("Notification sent!");
    }
}
