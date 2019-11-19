package com.creamsale.model;

import com.creamsale.dto.CashBackDTO;
import com.creamsale.dto.ProductDTO;
import com.creamsale.dto.ShopDTO;

import java.util.List;

public class OfferModel {
    private List<CashBackDTO> cashBacks;
    private ShopDTO shop;
    private ProductDTO product;

    public OfferModel(List<CashBackDTO> cashBacks, ShopDTO shop, ProductDTO product) {
        this.cashBacks = cashBacks;
        this.shop = shop;
        this.product = product;
    }

    public List<CashBackDTO> getCashBacks() {
        return cashBacks;
    }

    public void setCashBacks(List<CashBackDTO> cashBacks) {
        this.cashBacks = cashBacks;
    }

    public ShopDTO getShop() {
        return shop;
    }

    public void setShop(ShopDTO shop) {
        this.shop = shop;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
