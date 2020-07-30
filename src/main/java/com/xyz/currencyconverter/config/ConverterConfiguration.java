package com.xyz.currencyconverter.config;

import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.base.Splitter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "converter")
public class ConverterConfiguration {

    private String currencyCodes;

    public String getCurrencyCodes() {
        return currencyCodes;
    }

    public void setCurrencyCodes(String currencyCodes) {
        this.currencyCodes = currencyCodes;
    }

    public Map<String, Integer> getCurrencyCodesMap() {
        return Splitter.on(",").withKeyValueSeparator("=").split(currencyCodes).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, v -> Integer.parseInt(v.getValue())));
    }
}