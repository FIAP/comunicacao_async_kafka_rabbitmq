package dev.ghlima.demorabbitmq.consumer;

import dev.ghlima.demorabbitmq.configuration.RabbitMQConfig;
import dev.ghlima.demorabbitmq.dto.NewReservationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {

    private final Logger log = LoggerFactory.getLogger(PaymentConsumer.class);

    @RabbitListener(queues = RabbitMQConfig.PAYMENT_QUEUE)
    public void processPayment(NewReservationDTO reservation) {
        log.info("Processing payment for new reservation: {}", reservation);
    }
}