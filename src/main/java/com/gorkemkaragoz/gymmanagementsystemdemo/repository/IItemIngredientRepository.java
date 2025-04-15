package com.gorkemkaragoz.gymmanagementsystemdemo.repository;

import com.gorkemkaragoz.gymmanagementsystemdemo.entity.ItemIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemIngredientRepository extends JpaRepository<ItemIngredient, Integer> {
}
