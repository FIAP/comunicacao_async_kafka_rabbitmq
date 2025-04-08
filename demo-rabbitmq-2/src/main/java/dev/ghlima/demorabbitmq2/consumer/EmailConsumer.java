package dev.ghlima.demorabbitmq2.consumer;

import dev.ghlima.demorabbitmq2.configuration.RabbitMQFanoutConfig;
import dev.ghlima.demorabbitmq2.dto.NotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private final Logger log = LoggerFactory.getLogger(EmailConsumer.class);

    @RabbitListener(queues = RabbitMQFanoutConfig.EMAIL_QUEUE)
    public void receiveEmailNotification(NotificationDTO message) {
        log.info("Email notification received: {}", message);
    }
}
