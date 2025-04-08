package dev.ghlima.demorabbitmq2.consumer;

import dev.ghlima.demorabbitmq2.configuration.RabbitMQFanoutConfig;
import dev.ghlima.demorabbitmq2.dto.NotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SmsConsumer {

    private final Logger log = LoggerFactory.getLogger(SmsConsumer.class);

    @RabbitListener(queues = RabbitMQFanoutConfig.SMS_QUEUE)
    public void receiveSmsNotification(NotificationDTO message) {
        log.info("SMS notification received: {}", message);
    }
}