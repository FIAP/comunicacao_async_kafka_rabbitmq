package dev.ghlima.demorabbitmq3.consumer;

import dev.ghlima.demorabbitmq3.configuration.RabbitMQTopicConfig;
import dev.ghlima.demorabbitmq3.dto.VehicleEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CarEventConsumer {

    private final Logger log = LoggerFactory.getLogger(CarEventConsumer.class);

    @RabbitListener(queues = RabbitMQTopicConfig.CAR_QUEUE)
    public void receiveCarEvent(VehicleEventDTO event) {
       log.info("Evento de carro recebido: {}", event);
    }
}