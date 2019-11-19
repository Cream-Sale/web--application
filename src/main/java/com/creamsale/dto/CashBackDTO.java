package com.creamsale.dto;

import com.creamsale.enums.CashBack;
import com.creamsale.enums.shops.Shop;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.net.URI;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CashBackDTO {
    private CashBack name;

    private Map<Shop, SalePercentDTO> shops;

    private URI link;

    public CashBackDTO() {
    }

    public CashBackDTO(CashBack name, Map<Shop, SalePercentDTO> shops, URI link) {
        this.name = name;
        this.shops = shops;
        this.link = link;
    }

    public CashBack getName() {
        return name;
    }

    public void setName(CashBack name) {
        this.name = name;
    }

    public Map<Shop, SalePercentDTO> getShops() {
        return shops;
    }

    public void setShops(Map<Shop, SalePercentDTO> shops) {
        this.shops = shops;
    }

    public URI getLink() {
        return link;
    }

    public void setLink(URI link) {
        this.link = link;
    }
}
