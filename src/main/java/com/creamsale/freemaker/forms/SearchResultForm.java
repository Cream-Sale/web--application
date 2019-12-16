package com.creamsale.freemaker.forms;

public class SearchResultForm {
    private String productName;
    private Float price;
    private String cashBackName;
    private Float cashBackSale;
    private Float priceWithSale;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCashBackName() {
        return cashBackName;
    }

    public void setCashBackName(String cashBackName) {
        this.cashBackName = cashBackName;
    }

    public Float getCashBackSale() {
        return cashBackSale;
    }

    public void setCashBackSale(Float cashBackSale) {
        this.cashBackSale = cashBackSale;
    }

    public Float getPriceWithSale() {
        return priceWithSale;
    }

    public void setPriceWithSale(Float priceWithSale) {
        this.priceWithSale = priceWithSale;
    }
}
