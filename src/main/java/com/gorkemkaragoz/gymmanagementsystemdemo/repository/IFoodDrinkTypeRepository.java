package com.gorkemkaragoz.gymmanagementsystemdemo.repository;

import com.gorkemkaragoz.gymmanagementsystemdemo.entity.FoodDrinkType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodDrinkTypeRepository extends JpaRepository<FoodDrinkType, Integer> {
}