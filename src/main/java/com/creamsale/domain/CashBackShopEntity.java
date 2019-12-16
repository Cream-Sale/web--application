package com.creamsale.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CashBackShop")
public class CashBackShopEntity implements Serializable {

    private Integer id;
    private Long salePercent;
    private String description;
    private Integer cashBackId;
    private Integer shopInfoId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "salePercent", nullable = true, insertable = true, updatable = true, length = 3)
    public Long getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(Long salePercent) {
        this.salePercent = salePercent;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "cashBackId", nullable = true, insertable = true, updatable = true, length = 1000)
    public Integer getCashBackId() {
        return cashBackId;
    }

    public void setCashBackId(Integer cashBackId) {
        this.cashBackId = cashBackId;
    }

    @Basic
    @Column(name = "shopInfoId", nullable = true, insertable = true, updatable = true, length = 1000)
    public Integer getShopInfoId() {
        return shopInfoId;
    }

    public void setShopInfoId(Integer shopInfoId) {
        this.shopInfoId = shopInfoId;
    }
}
