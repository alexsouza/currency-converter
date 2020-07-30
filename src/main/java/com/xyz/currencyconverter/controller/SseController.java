package com.xyz.currencyconverter.controller;

import javax.servlet.http.HttpServletResponse;

import com.xyz.currencyconverter.message.CurrencyConverterMessageConsumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/api/emitter")
public class SseController {

    @GetMapping("/convertions")
    public SseEmitter handle(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-store");

        // SseEmitter emitter = new SseEmitter();
        SseEmitter emitter = new SseEmitter(180_000L);

        CurrencyConverterMessageConsumer.emitters.add(emitter);

        emitter.onCompletion(() -> CurrencyConverterMessageConsumer.emitters.remove(emitter));
        emitter.onTimeout(() -> CurrencyConverterMessageConsumer.emitters.remove(emitter));

        return emitter;
    }
}