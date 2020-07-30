package com.xyz.currencyconverter.message;

import java.util.UUID;

import com.xyz.currencyconverter.model.CurrencyData;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class CurrencyConverterMessageProducer {

    @Value("${message.topic.name}")
    private String topicName;
    private final KafkaTemplate<String, CurrencyData> kafkaTemplate;

    public CurrencyConverterMessageProducer(final KafkaTemplate<String, CurrencyData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(final @RequestBody CurrencyData data) {
        final String mensageKey = UUID.randomUUID().toString();
        kafkaTemplate.send(topicName, mensageKey, data);
    }

}