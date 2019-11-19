package com.creamsale.dto;

import com.creamsale.enums.categories.GeneralCategory;
import com.creamsale.enums.shops.Shop;

import java.net.URI;

public class ShopDTO {
    private Shop shopName;
    private GeneralCategory generalCategory;
    private URI link;

    public ShopDTO() {
    }

    public ShopDTO(Shop shopName, GeneralCategory generalCategory, URI link) {
        this.shopName = shopName;
        this.generalCategory = generalCategory;
        this.link = link;
    }

    public Shop getShopName() {
        return shopName;
    }

    public void setShopName(Shop shopName) {
        this.shopName = shopName;
    }

    public GeneralCategory getGeneralCategory() {
        return generalCategory;
    }

    public void setGeneralCategory(GeneralCategory generalCategory) {
        this.generalCategory = generalCategory;
    }

    public URI getLink() {
        return link;
    }

    public void setLink(URI link) {
        this.link = link;
    }
}
