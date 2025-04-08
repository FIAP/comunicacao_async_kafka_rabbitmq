package dev.ghlima.demokafka.dlt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.kafka.receiver.ReceiverRecord;

public class EventProcessor {
    private static final Logger log = LoggerFactory.getLogger(EventProcessor.class);
    private final ReactiveDeadLetterTopicProducer<String, String> deadLetterTopicProducer;

    public EventProcessor(ReactiveDeadLetterTopicProducer<String, String> deadLetterTopicProducer) {
        this.deadLetterTopicProducer = deadLetterTopicProducer;
    }

    public Mono<Void> process(ReceiverRecord<String, String> record){
        return Mono.just(record)
                .doOnNext(r -> {
                       if(r.key().endsWith("5"))
                           throw new RuntimeException("processing exception");
                    log.info("key: {}, value: {}", r.key(), r.value());
                    r.receiverOffset().acknowledge();
                })
                .onErrorMap(ex -> new RecordProcessingException(record, ex))
                .transform(this.deadLetterTopicProducer.recordProcessingErrorHandler());
    }
}
