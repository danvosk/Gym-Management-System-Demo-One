package com.gorkemkaragoz.gymmanagementsystemdemo.controller;


import com.gorkemkaragoz.gymmanagementsystemdemo.entity.FoodDrinkType;
import com.gorkemkaragoz.gymmanagementsystemdemo.exception.ResourceNotFoundException;
import com.gorkemkaragoz.gymmanagementsystemdemo.service.IFoodDrinkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food-drink-type")
public class FoodDrinkTypeController {

    private final IFoodDrinkTypeService iFoodDrinkTypeService;

    @Autowired
    public FoodDrinkTypeController(IFoodDrinkTypeService iFoodDrinkTypeService) {
        this.iFoodDrinkTypeService = iFoodDrinkTypeService;
    }

    // 🔹 GET /api/v1/food-drink-type
    @GetMapping
    public ResponseEntity<List<FoodDrinkType>> getAll() {
        List<FoodDrinkType> types = iFoodDrinkTypeService.findAll();
        if (types.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(types);
    }

    // 🔹 GET /api/v1/food-drink-type/{id}
    @GetMapping("/{id}")
    public ResponseEntity<FoodDrinkType> getById(@PathVariable Integer id) {
        FoodDrinkType type = iFoodDrinkTypeService.findById(id);
        if (type == null) {
            throw new ResourceNotFoundException("FoodDrinkType not found with id: " + id);
        }
        return ResponseEntity.ok(type);
    }

    // 🔹 POST /api/v1/food-drink-type
    @PostMapping
    public ResponseEntity<FoodDrinkType> create(@RequestBody FoodDrinkType foodDrinkType) {
        FoodDrinkType saved = iFoodDrinkTypeService.save(foodDrinkType);
        return ResponseEntity.status(201).body(saved); // 201 Created
    }

    // 🔹 PUT /api/v1/food-drink-type
    @PutMapping
    public ResponseEntity<FoodDrinkType> update(@RequestBody FoodDrinkType foodDrinkType) {
        FoodDrinkType existing = iFoodDrinkTypeService.findById(foodDrinkType.getId());
        if (existing == null) {
            throw new ResourceNotFoundException("Cannot update. FoodDrinkType not found with id: " + foodDrinkType.getId());
        }
        FoodDrinkType updated = iFoodDrinkTypeService.update(foodDrinkType);
        return ResponseEntity.ok(updated);
    }

    // 🔹 DELETE /api/v1/food-drink-type/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        FoodDrinkType existing = iFoodDrinkTypeService.findById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Cannot delete. FoodDrinkType not found with id: " + id);
        }
        iFoodDrinkTypeService.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

}
