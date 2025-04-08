package dev.ghlima.demorabbitmq2.consumer;

import dev.ghlima.demorabbitmq2.configuration.RabbitMQFanoutConfig;
import dev.ghlima.demorabbitmq2.dto.NotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PushConsumer {

    private final Logger log = LoggerFactory.getLogger(PushConsumer.class);

    @RabbitListener(queues = RabbitMQFanoutConfig.PUSH_QUEUE)
    public void receivePushNotification(NotificationDTO message) {
       log.info("Push notification received: {}", message);
    }
}