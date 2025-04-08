package dev.ghlima.demorabbitmq3.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

    public static final String EXCHANGE_NAME = "exchange_eventos";
    public static final String CAR_QUEUE = "vehicle_car_queue";
    public static final String MAINTENANCE_QUEUE = "maintenance_queue";
    public static final String RESERVATION_QUEUE = "reservation_queue";


    public static final String ROUTING_KEY_CAR_ALL = "veiculo.carro.*";
    public static final String ROUTING_KEY_MAINTENANCE = "*.*.manutencao";
    public static final String ROUTING_KEY_RESERVATION = "veiculo.*.reserva";

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue carQueue() {
        return new Queue(CAR_QUEUE, true);
    }

    @Bean
    public Queue maintenanceQueue() {
        return new Queue(MAINTENANCE_QUEUE, true);
    }

    @Bean
    public Queue reservationQueue() {
        return new Queue(RESERVATION_QUEUE, true);
    }

    @Bean
    public Binding bindingCarQueue(Queue carQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(carQueue).to(topicExchange).with(ROUTING_KEY_CAR_ALL);
    }

    @Bean
    public Binding bindingMaintenanceQueue(Queue maintenanceQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(maintenanceQueue).to(topicExchange).with(ROUTING_KEY_MAINTENANCE);
    }

    @Bean
    public Binding bindingReservationQueue(Queue reservationQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(reservationQueue).to(topicExchange).with(ROUTING_KEY_RESERVATION);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
