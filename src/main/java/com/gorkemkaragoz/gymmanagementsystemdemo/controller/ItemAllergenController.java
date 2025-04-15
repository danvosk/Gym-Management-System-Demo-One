package com.gorkemkaragoz.gymmanagementsystemdemo.controller;

import com.gorkemkaragoz.gymmanagementsystemdemo.entity.ItemAllergen;
import com.gorkemkaragoz.gymmanagementsystemdemo.exception.ResourceNotFoundException;
import com.gorkemkaragoz.gymmanagementsystemdemo.service.IItemAllergenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item-allergen")
public class ItemAllergenController {

    private final IItemAllergenService iItemAllergenService;

    @Autowired
    public ItemAllergenController(IItemAllergenService iItemAllergenService) {
        this.iItemAllergenService = iItemAllergenService;
    }

    // 🔹 GET /api/v1/item-allergen
    @GetMapping
    public ResponseEntity<List<ItemAllergen>> getAll() {
        List<ItemAllergen> list = iItemAllergenService.findAll();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    // 🔹 GET /api/v1/item-allergen/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ItemAllergen> getById(@PathVariable Integer id) {
        ItemAllergen allergen = iItemAllergenService.findById(id);
        if (allergen == null) {
            throw new ResourceNotFoundException("ItemAllergen not found with id: " + id);
        }
        return ResponseEntity.ok(allergen);
    }

    // 🔹 POST
    @PostMapping
    public ResponseEntity<ItemAllergen> create(@RequestBody ItemAllergen itemAllergen) {
        ItemAllergen saved = iItemAllergenService.save(itemAllergen);
        return ResponseEntity.status(201).body(saved);
    }

    // 🔹 PUT
    @PutMapping
    public ResponseEntity<ItemAllergen> update(@RequestBody ItemAllergen itemAllergen) {
        ItemAllergen existing = iItemAllergenService.findById(itemAllergen.getId());
        if (existing == null) {
            throw new ResourceNotFoundException("Cannot update. ItemAllergen not found with id: " + itemAllergen.getId());
        }
        ItemAllergen updated = iItemAllergenService.update(itemAllergen);
        return ResponseEntity.ok(updated);
    }

    // 🔹 DELETE /api/v1/item-allergen/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        ItemAllergen existing = iItemAllergenService.findById(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Cannot delete. ItemAllergen not found with id: " + id);
        }
        iItemAllergenService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
