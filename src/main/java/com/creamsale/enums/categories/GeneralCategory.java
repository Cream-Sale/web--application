package com.creamsale.enums.categories;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GeneralCategory {
    ELECTRONICS("electronics"),
    CLOTHES_AND_SHOES("clothesAndShoes"),
    TRAVEL("travel");

    private String value;

    GeneralCategory(String value){
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
