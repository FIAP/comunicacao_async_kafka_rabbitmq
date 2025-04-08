package dev.ghlima.demorabbitmq3.consumer;

import dev.ghlima.demorabbitmq3.configuration.RabbitMQTopicConfig;
import dev.ghlima.demorabbitmq3.dto.VehicleEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationEventConsumer {

    private final Logger log = LoggerFactory.getLogger(ReservationEventConsumer.class);

    @RabbitListener(queues = RabbitMQTopicConfig.RESERVATION_QUEUE)
    public void receiveReservationEvent(VehicleEventDTO event) {
        log.info("Evento de reserva recebido: {}", event);
    }
}
