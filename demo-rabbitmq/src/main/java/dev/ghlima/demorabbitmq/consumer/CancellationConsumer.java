package dev.ghlima.demorabbitmq.consumer;

import dev.ghlima.demorabbitmq.configuration.RabbitMQConfig;
import dev.ghlima.demorabbitmq.dto.CancellationReservationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CancellationConsumer {

    private final Logger log = LoggerFactory.getLogger(CancellationConsumer.class);

    @RabbitListener(queues = RabbitMQConfig.REFUND_QUEUE)
    public void processCancellation(CancellationReservationDTO cancellation) {
        log.info("Processing payment for new reservation: {}", cancellation.getReservationId());
    }
}
