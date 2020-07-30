package com.xyz.currencyconverter.rest.client;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "converter-service", path = "/converter", url = "https://www3.bcb.gov.br/bc_moeda/rest")
public interface ConverterService {

    @Cacheable(cacheNames = "currency", key = "#value.toString() + #from.toString() + #to.toString() + #date.toString()")
    @GetMapping(value = "/{value}/1/{from}/{to}/{date}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ConvertedValue convert(@PathVariable("value") Double value, @PathVariable("from") Integer from,
            @PathVariable("to") Integer to, @PathVariable("date") String date);

}