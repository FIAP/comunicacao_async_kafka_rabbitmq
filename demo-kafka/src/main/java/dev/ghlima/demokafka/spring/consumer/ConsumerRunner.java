package dev.ghlima.demokafka.spring.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.reactive.ReactiveKafkaConsumerTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ConsumerRunner.class);

    @Autowired
    private ReactiveKafkaConsumerTemplate<String, Rental> template;

    @Override
    public void run(String... args) throws Exception {
        this.template.receive()
                .doOnNext(r -> log.info("key: {}, value: {}", r.key(), r.value()))
                .subscribe();
    }
}
