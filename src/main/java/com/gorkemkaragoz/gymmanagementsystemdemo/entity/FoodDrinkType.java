package com.gorkemkaragoz.gymmanagementsystemdemo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "food_drink_types")
public class FoodDrinkType {

    @Id // Primary key olduğunu belirtir.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan ID (auto_increment).
    private int id;

    @Column(name = "name", nullable = false) // "name" adlı tablo sütunuyla eşleşir, NOT NULL kısıtlaması var.
    private String name;

    @OneToMany(mappedBy = "type") // Bir tür, birden fazla ürünle ilişkilidir.
    @JsonManagedReference
    private List<MenuItem> menuItems;

    public FoodDrinkType() {} // Boş constructor – JPA için zorunludur.

    public FoodDrinkType(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

}
