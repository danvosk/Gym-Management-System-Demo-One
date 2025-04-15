package com.gorkemkaragoz.gymmanagementsystemdemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "item_allergens")
public class ItemAllergen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "allergen_name") // Alerjen adı (örn: Fındık)
    private String allergenName;

    @ManyToOne // Birden fazla alerjen sadece tek bir ürüne bağlıdır.
    @JoinColumn(name = "item_id")
    @JsonBackReference
    private MenuItem item;

    public ItemAllergen() {}

    public ItemAllergen(String allergenName, MenuItem item) {
        this.allergenName = allergenName;
        this.item = item;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAllergenName() {
        return allergenName;
    }
    public void setAllergenName(String allergenName) {
        this.allergenName = allergenName;
    }
    public MenuItem getItem() {
        return item;
    }
    public void setItem(MenuItem item) {
        this.item = item;
    }

}
