package com.creamsale.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Currency {
    BYN("BYN"),
    USD("USD"),
    EUR("EUR"),
    RUB("RUB");

    String value;

    Currency(String value){
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }
}
