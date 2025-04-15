package com.gorkemkaragoz.gymmanagementsystemdemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="item_ingredients")
public class ItemIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne // Birden fazla içerik sadece tek bir ürüne aittir.
    @JoinColumn(name = "item_id") // Foreign key sütunu
    @JsonBackReference
    private MenuItem item;

    @Column(name = "ingredient_name") // İçeriğin adı (örn: Badem)
    private String ingredientName;

    public ItemIngredient() {}

    public ItemIngredient(String ingredientName, MenuItem item) {
        this.ingredientName = ingredientName;
        this.item = item;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getIngredientName() {
        return ingredientName;
    }
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
    public MenuItem getItem() {
        return item;
    }
    public void setItem(MenuItem item) {
        this.item = item;
    }
}
