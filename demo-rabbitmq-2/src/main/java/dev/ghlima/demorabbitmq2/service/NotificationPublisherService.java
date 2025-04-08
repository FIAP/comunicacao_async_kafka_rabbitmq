package dev.ghlima.demorabbitmq2.service;

import dev.ghlima.demorabbitmq2.configuration.RabbitMQFanoutConfig;
import dev.ghlima.demorabbitmq2.dto.NotificationDTO;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationPublisherService {

    private final RabbitTemplate rabbitTemplate;

    NotificationPublisherService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendNotification(NotificationDTO message) {
        rabbitTemplate.convertAndSend(RabbitMQFanoutConfig.EXCHANGE_NAME, "", message);
    }
}
