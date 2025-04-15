package com.gorkemkaragoz.gymmanagementsystemdemo.controller;


import com.gorkemkaragoz.gymmanagementsystemdemo.entity.MenuItem;
import com.gorkemkaragoz.gymmanagementsystemdemo.exception.ResourceNotFoundException;
import com.gorkemkaragoz.gymmanagementsystemdemo.service.IMenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu-item")
public class MenuItemController {

    private final IMenuItemService iMenuItemService;

    @Autowired
    public MenuItemController(IMenuItemService iMenuItemService) {
        this.iMenuItemService = iMenuItemService;
    }

    // 🔹 GET /api/v1/menu-item
    @GetMapping
    public ResponseEntity<List<MenuItem>> getAll() {

        List<MenuItem> list = iMenuItemService.findAll();

        if(list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);

    }

    // 🔹 GET /api/v1/menu-item/{id}
    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getById(@PathVariable Integer id){

        MenuItem type = iMenuItemService.findById(id);

        if(type == null){
            throw new ResourceNotFoundException("MenuItem not found with id" + id);
        }
        return ResponseEntity.ok(type);

    }

    // 🔹 POST /api/v1/menu-item
    @PostMapping
    public ResponseEntity<MenuItem> create(@RequestBody MenuItem menuItem){
        MenuItem saved = iMenuItemService.save(menuItem);
        return ResponseEntity.status(201).body(saved);
    }

    // 🔹 PUT /api/v1/menu-item
    @PutMapping
    public ResponseEntity<MenuItem> update(@RequestBody MenuItem menuItem ){
        MenuItem existing = iMenuItemService.findById(menuItem.getId());
        if (existing == null) {
            throw new ResourceNotFoundException("Cannot update. MenuItem not found with id: " +menuItem.getId());
        }
        MenuItem updated = iMenuItemService.update(menuItem);
        return ResponseEntity.ok(updated);

    }

    // 🔹 DELETE /api/v1/menu-item/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        MenuItem existing = iMenuItemService.findById(id);
        if(existing == null) {
            throw new ResourceNotFoundException("Cannot delete. MenuItem not found with id: " + id);
        }
        iMenuItemService.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 No Content

    }


}
