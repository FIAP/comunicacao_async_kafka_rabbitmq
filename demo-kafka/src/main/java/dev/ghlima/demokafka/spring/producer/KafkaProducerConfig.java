package dev.ghlima.demokafka.spring.producer;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import reactor.kafka.sender.SenderOptions;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public SenderOptions<String, CarRental> senderOptions(KafkaProperties kafkaProperties, SslBundles sslBundles){
        return SenderOptions.<String, CarRental>create(kafkaProperties.buildProducerProperties(sslBundles));
    }

    @Bean
    public ReactiveKafkaProducerTemplate<String, CarRental> producerTemplate(SenderOptions<String, CarRental> options){
        return new ReactiveKafkaProducerTemplate<>(options);
    }

}
