package com.creamsale.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CashBack {
    LETYSHOPS("letyshops"),
    BACKIT("backit");

    private String value;

    CashBack(String cashBackName){
        this.value = cashBackName;
    }

    @JsonValue
    public String value() {
        return value;
    }
}
