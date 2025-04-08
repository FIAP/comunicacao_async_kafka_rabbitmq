package dev.ghlima.demorabbitmq.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "reservation_exchange";
    public static final String PAYMENT_QUEUE = "payment_queue";
    public static final String REFUND_QUEUE = "refund_queue";
    public static final String ROUTING_KEY_NEW = "reservation.new";
    public static final String ROUTING_KEY_CANCELLED = "reservation.cancelled";

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue paymentQueue() {
        return new Queue(PAYMENT_QUEUE, true);
    }

    @Bean
    public Queue refundQueue() {
        return new Queue(REFUND_QUEUE, true);
    }

    @Bean
    public Binding paymentBinding(Queue paymentQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(paymentQueue).to(directExchange).with(ROUTING_KEY_NEW);
    }

    @Bean
    public Binding refundBinding(Queue refundQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(refundQueue).to(directExchange).with(ROUTING_KEY_CANCELLED);
    }


    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}

