package dev.ghlima.demorabbitmq.service;

import dev.ghlima.demorabbitmq.configuration.RabbitMQConfig;
import dev.ghlima.demorabbitmq.dto.CancellationReservationDTO;
import dev.ghlima.demorabbitmq.dto.NewReservationDTO;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReservationPublisherService {
    private final RabbitTemplate rabbitTemplate;

    public void sendNewReservation(NewReservationDTO reservation)  {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_NEW, reservation);
    }

    public void sendCancellationReservation(CancellationReservationDTO reservation) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_CANCELLED, reservation);
    }
}
