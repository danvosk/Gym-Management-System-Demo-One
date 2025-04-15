package com.gorkemkaragoz.gymmanagementsystemdemo.controller;

import com.gorkemkaragoz.gymmanagementsystemdemo.entity.ItemIngredient;
import com.gorkemkaragoz.gymmanagementsystemdemo.exception.ResourceNotFoundException;
import com.gorkemkaragoz.gymmanagementsystemdemo.service.IItemIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item-ingredient")
public class ItemIngredientController {

    private final IItemIngredientService iItemIngredientService;

    @Autowired
    public ItemIngredientController(IItemIngredientService iItemIngredientService) {
        this.iItemIngredientService = iItemIngredientService;
    }

    // 🔹 GET /api/v1/item-ingredient
    @GetMapping
    public ResponseEntity<List<ItemIngredient>> getAll(){
        List<ItemIngredient> list = iItemIngredientService.findAll();

        if(list.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);

    }

    // 🔹 GET /api/v1/item-ingredient/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ItemIngredient> getById(@PathVariable Integer id){

        ItemIngredient ingredient = iItemIngredientService.findById(id);

        if (ingredient == null ){
            throw new ResourceNotFoundException("ItemIngredient not found with id: " + id);
        }
        return ResponseEntity.ok(ingredient);

    }

    // 🔹 POST /api/v1/item-ingredient
    @PostMapping
    public ResponseEntity<ItemIngredient> create(@RequestBody ItemIngredient itemIngredient){
        ItemIngredient saved = iItemIngredientService.save(itemIngredient);
        return ResponseEntity.status(201).body(saved);
    }

    // 🔹 PUT
    @PutMapping
    public ResponseEntity<ItemIngredient> update(@RequestBody ItemIngredient itemIngredient) {
        ItemIngredient existing = iItemIngredientService.findById(itemIngredient.getId());
        if (existing == null) {
            throw new ResourceNotFoundException("Cannot update. ItemAllergen not found with id: " + itemIngredient.getId());
        }
        ItemIngredient updated = iItemIngredientService.update(itemIngredient);
        return ResponseEntity.ok(updated);
    }

    // 🔹 DELETE /api/v1/item-ingredient/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        ItemIngredient existing = iItemIngredientService.findById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Cannot delete. ItemAllergen not found with id: " + id);
        }
        iItemIngredientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
