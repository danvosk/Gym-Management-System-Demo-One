package com.gorkemkaragoz.gymmanagementsystemdemo.serviceImpl;

import com.gorkemkaragoz.gymmanagementsystemdemo.entity.FoodDrinkType;
import com.gorkemkaragoz.gymmanagementsystemdemo.repository.IFoodDrinkTypeRepository;
import com.gorkemkaragoz.gymmanagementsystemdemo.service.IFoodDrinkTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodDrinkTypeServiceImpl implements IFoodDrinkTypeService{

    private final IFoodDrinkTypeRepository foodDrinkTypeRepository;

    @Autowired
    public FoodDrinkTypeServiceImpl(IFoodDrinkTypeRepository foodDrinkTypeRepository) {
        this.foodDrinkTypeRepository = foodDrinkTypeRepository;
    }


    @Override
    public List<FoodDrinkType> findAll() {
        return foodDrinkTypeRepository.findAll();
    }

    @Override
    public FoodDrinkType findById(Integer id) {
        return foodDrinkTypeRepository.findById(id).orElse(null);
    }

    @Override
    public FoodDrinkType save(FoodDrinkType foodDrinkType) {
        return foodDrinkTypeRepository.save(foodDrinkType);
    }

    @Override
    public FoodDrinkType update(FoodDrinkType foodDrinkType) {
        return foodDrinkTypeRepository.save(foodDrinkType);
    }

    @Override
    public void deleteById(Integer id) {
        foodDrinkTypeRepository.deleteById(id);
    }

}
