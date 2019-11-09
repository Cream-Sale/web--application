package com.creamsale.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {
    WATCH("watch"),
    PHONE("phone");

    String value;

    Category(String value){
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }
}
