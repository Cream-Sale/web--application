package com.creamsale.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cashback_sale")
public class CashBackSaleEntity implements Serializable {

    private Integer id;
    private ShopEntity shop;
    private Long salePercent;
    private String description;
    private CashBackEntity cashBack;

    @ManyToOne
    @JoinColumn(name = "cashBackId", referencedColumnName = "id")
    public CashBackEntity getCashBack() {
        return this.cashBack;
    }

    public void setCashBack(CashBackEntity cashBack) {
        this.cashBack = cashBack;
    }

    @ManyToOne
    @JoinColumn(name = "shopId", referencedColumnName = "id")
    public ShopEntity getShop() {
        return this.shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashBackSaleEntity that = (CashBackSaleEntity) o;
        return Objects.equals(salePercent, that.salePercent) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salePercent, description);
    }

    @Override
    public String toString() {
        return "CashBackSale{" +
                "salePercent=" + salePercent +
                ", description='" + description + '\'' +
                '}';
    }
}
