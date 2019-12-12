package com.creamsale.domain;

import com.creamsale.enums.categories.GeneralCategory;

import java.io.Serializable;

public class ProductEntity implements Serializable {

    private Integer id;
    private GeneralCategory generalCategory;
    private String brand;
    private String name;

    public GeneralCategory getGeneralCategory() {
        return generalCategory;
    }

    public void setGeneralCategory(GeneralCategory generalCategory) {
        this.generalCategory = generalCategory;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
