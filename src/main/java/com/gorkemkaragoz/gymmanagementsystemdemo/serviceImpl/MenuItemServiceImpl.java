package com.gorkemkaragoz.gymmanagementsystemdemo.serviceImpl;

import com.gorkemkaragoz.gymmanagementsystemdemo.entity.MenuItem;
import com.gorkemkaragoz.gymmanagementsystemdemo.repository.IMenuItemRepository;
import com.gorkemkaragoz.gymmanagementsystemdemo.service.IMenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements IMenuItemService {

    private final IMenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemServiceImpl(IMenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem findById(Integer id) {
        return menuItemRepository.findById(id).orElse(null);
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem update(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public void deleteById(Integer id) {
        menuItemRepository.deleteById(id);
    }
}