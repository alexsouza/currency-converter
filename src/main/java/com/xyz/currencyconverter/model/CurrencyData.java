package com.xyz.currencyconverter.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class CurrencyData {

    private Double value;
    private String from;
    @NotNull(message = "Invalid code")
    private Integer fromCode;
    private String to;
    @NotNull(message = "Invalid code")
    private Integer toCode;
    private BigDecimal convertedValue;

    // @JsonIgnore
    private String day;
    // @JsonIgnore
    private String month;
    // @JsonIgnore
    private String year;

    public Double getValue() {
        return value;
    }

    public CurrencyData setValue(Double value) {
        this.value = value;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public CurrencyData setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getTo() {
        return to;
    }

    public CurrencyData setTo(String to) {
        this.to = to;
        return this;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public CurrencyData setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
        return this;
    }

    public Integer getFromCode() {
        return fromCode;
    }

    public CurrencyData setFromCode(Integer fromCode) {
        this.fromCode = fromCode;
        return this;
    }

    public Integer getToCode() {
        return toCode;
    }

    public CurrencyData setToCode(Integer toCode) {
        this.toCode = toCode;
        return this;
    }

    public String getDay() {
        return day;
    }

    public CurrencyData setDay(String day) {
        this.day = day;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public CurrencyData setMonth(String month) {
        this.month = month;
        return this;
    }

    public String getYear() {
        return year;
    }

    public CurrencyData setYear(String year) {
        this.year = year;
        return this;
    }

    public String getDate() {
        return String.format("%s-%s-%s", getDay(), getMonth(), getYear());
    }
}