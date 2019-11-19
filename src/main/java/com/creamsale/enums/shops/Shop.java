package com.creamsale.enums.shops;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Shop {

    FIVE_ELEMENT("5-element"),
    SVYAZNOY("svyaznoy"),
    LAMODA("lamoda");

    private String shopName;

    Shop(String shopName){
        this.shopName = shopName;
    }

    @JsonValue
    public String value() {
        return shopName;
    }
}
