package com.gorkemkaragoz.gymmanagementsystemdemo.service;

import com.gorkemkaragoz.gymmanagementsystemdemo.entity.ItemIngredient;

import java.util.List;

public interface IItemIngredientService {

    List<ItemIngredient> findAll();
    ItemIngredient findById(Integer id);
    ItemIngredient save(ItemIngredient itemIngredient);
    ItemIngredient update(ItemIngredient itemIngredient);
    void deleteById(Integer id);

}
