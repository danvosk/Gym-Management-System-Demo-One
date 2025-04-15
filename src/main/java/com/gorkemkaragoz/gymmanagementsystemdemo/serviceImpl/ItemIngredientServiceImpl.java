package com.gorkemkaragoz.gymmanagementsystemdemo.serviceImpl;

import com.gorkemkaragoz.gymmanagementsystemdemo.entity.ItemIngredient;
import com.gorkemkaragoz.gymmanagementsystemdemo.repository.IItemIngredientRepository;
import com.gorkemkaragoz.gymmanagementsystemdemo.service.IItemIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemIngredientServiceImpl implements IItemIngredientService {

    private final IItemIngredientRepository itemIngredientRepository;

    @Autowired
    public ItemIngredientServiceImpl(IItemIngredientRepository itemIngredientRepository) {
        this.itemIngredientRepository = itemIngredientRepository;
    }

    @Override
    public List<ItemIngredient> findAll() {
        return itemIngredientRepository.findAll();
    }

    @Override
    public ItemIngredient findById(Integer id) {
        return itemIngredientRepository.findById(id).orElse(null);
    }

    @Override
    public ItemIngredient save(ItemIngredient itemIngredient) {
        return itemIngredientRepository.save(itemIngredient);
    }

    @Override
    public ItemIngredient update(ItemIngredient itemIngredient) {
        return itemIngredientRepository.save(itemIngredient);
    }

    @Override
    public void deleteById(Integer id) {
         itemIngredientRepository.deleteById(id);
    }
}
