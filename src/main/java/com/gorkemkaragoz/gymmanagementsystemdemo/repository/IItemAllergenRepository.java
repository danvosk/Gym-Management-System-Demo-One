package com.gorkemkaragoz.gymmanagementsystemdemo.repository;

import com.gorkemkaragoz.gymmanagementsystemdemo.entity.ItemAllergen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemAllergenRepository extends JpaRepository<ItemAllergen, Integer> {
}
