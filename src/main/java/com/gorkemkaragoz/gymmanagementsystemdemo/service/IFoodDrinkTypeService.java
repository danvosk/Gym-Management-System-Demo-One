package com.gorkemkaragoz.gymmanagementsystemdemo.service;

import com.gorkemkaragoz.gymmanagementsystemdemo.entity.FoodDrinkType;

import java.util.List;

public interface IFoodDrinkTypeService {

    List<FoodDrinkType> findAll();
    FoodDrinkType findById(Integer id);
    FoodDrinkType save(FoodDrinkType foodDrinkType);
    FoodDrinkType update(FoodDrinkType foodDrinkType);
    void deleteById(Integer id);

}
