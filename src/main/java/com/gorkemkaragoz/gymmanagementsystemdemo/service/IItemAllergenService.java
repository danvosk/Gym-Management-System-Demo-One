package com.gorkemkaragoz.gymmanagementsystemdemo.service;

import com.gorkemkaragoz.gymmanagementsystemdemo.entity.ItemAllergen;

import java.util.List;

public interface IItemAllergenService {

    List<ItemAllergen> findAll();
    ItemAllergen findById(Integer id);
    ItemAllergen save(ItemAllergen itemAllergen);
    ItemAllergen update(ItemAllergen itemAllergen);
    void deleteById(Integer id);

}
