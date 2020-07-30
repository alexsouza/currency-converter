package com.xyz.currencyconverter.message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.xyz.currencyconverter.model.CurrencyData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
public class CurrencyConverterMessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyConverterMessageConsumer.class);
    public static CopyOnWriteArrayList<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    @KafkaListener(topics = "${message.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void process(CurrencyData data) {
        LOGGER.info("Currency data : " + data);
        List<SseEmitter> deadEmitters = new ArrayList<>();
        emitters.forEach(emitter -> {
            try {
                emitter.send(data);

                // close connnection, browser automatically reconnects
                emitter.complete();
            } catch (Exception e) {
                deadEmitters.add(emitter);
            }
        });
    }
}