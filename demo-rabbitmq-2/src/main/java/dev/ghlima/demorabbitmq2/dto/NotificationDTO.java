package dev.ghlima.demorabbitmq2.dto;

import java.time.LocalDateTime;


public record NotificationDTO(
         String notificationId,
         String title,
         String message,
         LocalDateTime sentAt
) {}
