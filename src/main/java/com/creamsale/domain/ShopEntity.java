package com.creamsale.domain;

import com.creamsale.enums.categories.GeneralCategory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "shop")
public class ShopEntity implements Serializable {

    private Integer id;
    private String name;
    private GeneralCategory generalCategory;
    private String link;

    /*private Set<CashBackEntity> cashBacks = new HashSet<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cashback",
            //foreign key for EmployeeEntity in employee_car table
            joinColumns = @JoinColumn(name = "id"),
            //foreign key for other side - EmployeeEntity in employee_car table
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    public Set<CashBackEntity> getCashBacks () {
        return cashBacks;
    }

    public void setCars(Set<CashBackEntity> cashBacks) {
        this.cashBacks = cashBacks;
    }*/

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
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "generalCategory", nullable = true, insertable = true, updatable = true, length = 100)
    @Enumerated(EnumType.STRING)
    public GeneralCategory getGeneralCategory() {
        return generalCategory;
    }

    public void setGeneralCategory(GeneralCategory generalCategory) {
        this.generalCategory = generalCategory;
    }

    @Basic
    @Column(name = "link", nullable = true, insertable = true, updatable = true, length = 100)
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
        ShopEntity that = (ShopEntity) o;
        return Objects.equals(name, that.name) &&
                generalCategory == that.generalCategory &&
                Objects.equals(link, that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, generalCategory, link);
    }

    @Override
    public String toString() {
        return "ShopEntity{" +
                "name='" + name + '\'' +
                ", generalCategory=" + generalCategory +
                ", link='" + link + '\'' +
                '}';
    }
}
