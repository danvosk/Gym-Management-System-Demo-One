package com.gorkemkaragoz.gymmanagementsystemdemo.serviceImpl;

import com.gorkemkaragoz.gymmanagementsystemdemo.entity.ItemAllergen;
import com.gorkemkaragoz.gymmanagementsystemdemo.repository.IItemAllergenRepository;
import com.gorkemkaragoz.gymmanagementsystemdemo.service.IItemAllergenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemAllergenServiceImpl implements IItemAllergenService {

    private IItemAllergenRepository itemAllergenRepository;

    @Autowired
    public ItemAllergenServiceImpl(IItemAllergenRepository itemAllergenRepository) {
        this.itemAllergenRepository = itemAllergenRepository;
    }

    @Override
    public List<ItemAllergen> findAll() {
        return itemAllergenRepository.findAll();
    }

    @Override
    public ItemAllergen findById(Integer id) {
        return itemAllergenRepository.findById(id).orElse(null);
    }

    @Override
    public ItemAllergen save(ItemAllergen itemAllergen) {
        return itemAllergenRepository.save(itemAllergen);
    }

    @Override
    public ItemAllergen update(ItemAllergen itemAllergen) {
        return itemAllergenRepository.save(itemAllergen);
    }

    @Override
    public void deleteById(Integer id) {
        itemAllergenRepository.deleteById(id);
    }
}
