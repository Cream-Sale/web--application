package com.creamsale.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CashBack {
    LETYSHOPS("letyshops");

    private String cashBackName;

    CashBack(String cashBackName){
        this.cashBackName = cashBackName;
    }

    @JsonValue
    public String getCashBackName() {
        return cashBackName;
    }
}
