package com.gorkemkaragoz.gymmanagementsystemdemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.*;
import java.math.BigDecimal;

@Entity
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false) // name sütunu NOT NULL olmalı
    private String name;

    @Column(precision = 6, scale = 2) // price alanı DECIMAL(6,2) formatında
    private BigDecimal price;

    @ManyToOne // Her menü ürünü bir ürün türüne aittir.
    @JoinColumn(name = "type_id") // Foreign key sütunu
    @JsonBackReference
    private FoodDrinkType type;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL) // Bir menüdeki ürünün birden çok içeriği olabilir
    @JsonManagedReference
    private List<ItemIngredient> ingredients;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL) // Bir menüdeki ürünün birden çok alerjeni olabilir
    @JsonManagedReference
    private List<ItemAllergen> allergens;

    public MenuItem() {}

    public MenuItem(String name, BigDecimal price, FoodDrinkType type) {
        this.name = name;
        this.price = price;
        this.type = type;
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
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public FoodDrinkType getType() {
        return type;
    }
    public void setType(FoodDrinkType type) {
        this.type = type;
    }
    public List<ItemIngredient> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<ItemIngredient> ingredients) {
        this.ingredients = ingredients;
    }
    public List<ItemAllergen> getAllergens() {
        return allergens;
    }
    public void setAllergens(List<ItemAllergen> allergens) {
        this.allergens = allergens;
    }

}
