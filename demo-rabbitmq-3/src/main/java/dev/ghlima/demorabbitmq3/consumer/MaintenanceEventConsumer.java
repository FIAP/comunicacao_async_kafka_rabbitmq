package dev.ghlima.demorabbitmq3.consumer;

import dev.ghlima.demorabbitmq3.configuration.RabbitMQTopicConfig;
import dev.ghlima.demorabbitmq3.dto.VehicleEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceEventConsumer {

    private final Logger log = LoggerFactory.getLogger(MaintenanceEventConsumer.class);

    @RabbitListener(queues = RabbitMQTopicConfig.MAINTENANCE_QUEUE)
    public void receiveMaintenanceEvent(VehicleEventDTO event) {
        log.info("Evento de manutenção recebido: {}", event);
    }
}
