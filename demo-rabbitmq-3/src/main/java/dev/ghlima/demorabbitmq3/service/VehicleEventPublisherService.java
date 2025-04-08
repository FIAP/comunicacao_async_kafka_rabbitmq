package dev.ghlima.demorabbitmq3.service;

import dev.ghlima.demorabbitmq3.configuration.RabbitMQTopicConfig;
import dev.ghlima.demorabbitmq3.dto.VehicleEventDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class VehicleEventPublisherService {
    private final RabbitTemplate rabbitTemplate;

    public VehicleEventPublisherService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Publica o evento utilizando a routing key definida.
     * A routing key é construída como: "veiculo.{vehicleType}.{eventAction}"
     *
     * @param event      Objeto com os dados do evento.
     * @param routingKey Chave de roteamento para envio.
     */
    public void publishEvent(VehicleEventDTO event, String routingKey) {
        rabbitTemplate.convertAndSend(RabbitMQTopicConfig.EXCHANGE_NAME, routingKey, event);
    }
}
