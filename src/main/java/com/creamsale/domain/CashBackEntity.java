package com.creamsale.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CashBack")
public class CashBackEntity implements Serializable {

    private Integer id;
    private String name;
    private String link;
    private Set<CashBackShopInfoEntity> cashBackShopsInfo = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cash_back_shop_test", joinColumns = @JoinColumn(name = "cashBackId"),
            inverseJoinColumns = @JoinColumn(name = "shopInfoId"))
    public Set<CashBackShopInfoEntity> getCashBackShopsInfo() {
        return cashBackShopsInfo;
    }

    public void setCashBackShopsInfo(Set<CashBackShopInfoEntity> cashBackShopsInfo) {
        this.cashBackShopsInfo = cashBackShopsInfo;
    }

    public void addCashBackShopsInfo(CashBackShopInfoEntity car) {
        cashBackShopsInfo.add(car);
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
    @Column(name = "name", nullable = true, insertable = true, updatable = true, unique = true, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "link", nullable = true, insertable = true, updatable = true, length = 200)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CashBackEntity that = (CashBackEntity) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, link);
    }

    @Override
    public String toString() {
        return "CashBackEntity{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
