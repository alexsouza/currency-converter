package com.xyz.currencyconverter.controller;

import com.xyz.currencyconverter.config.ConverterConfiguration;
import com.xyz.currencyconverter.message.CurrencyConverterMessageProducer;
import com.xyz.currencyconverter.model.CurrencyData;
import com.xyz.currencyconverter.rest.client.ConvertedValue;
import com.xyz.currencyconverter.rest.client.ConverterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/converter")
public class CurrencyConverterController {

        private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyConverterController.class);

        @Autowired
        ConverterConfiguration config;

        @Autowired
        CurrencyConverterMessageProducer messageProducer;

        @Autowired
        ConverterService service;

        @GetMapping("/{from}/{to}/{value}/{day}/{month}/{year}")
        public CurrencyData convert(@PathVariable("from") String from, @PathVariable("to") String to,
                        @PathVariable("value") Double value, @PathVariable("day") String day,
                        @PathVariable("month") String month, @PathVariable("year") String year) {
                LOGGER.debug(String.format("Init currency convertion from %s (%s) to %s ", from, value, to));

                // init the response data
                CurrencyData currencyData = new CurrencyData();
                currencyData.setDay(day).setMonth(month).setYear(year).setFrom(from)
                                .setFromCode(config.getCurrencyCodesMap().get(from)).setTo(to)
                                .setToCode(config.getCurrencyCodesMap().get(to)).setValue(value);

                ConvertedValue convertedServiceResponse = service.convert(value, currencyData.getFromCode(),
                                currencyData.getToCode(), currencyData.getDate());

                LOGGER.debug(String.format("Returned from service => %s ", convertedServiceResponse));

                currencyData.setConvertedValue(convertedServiceResponse.getValue());

                messageProducer.send(currencyData);

                return currencyData;
        }

}