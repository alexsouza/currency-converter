package com.xyz.currencyconverter.rest.client;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConvertedValue implements Serializable {

    private static final long serialVersionUID = 7001318379548296365L;

    private String name;
    private String declaredType;
    private BigDecimal value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeclaredType() {
        return declaredType;
    }

    public void setDeclaredType(String declaredType) {
        this.declaredType = declaredType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ConvertedValue [declaredType=" + declaredType + ", name=" + name + ", value=" + value + "]";
    }
}
