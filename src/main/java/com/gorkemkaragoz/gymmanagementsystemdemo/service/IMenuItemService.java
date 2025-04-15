package com.gorkemkaragoz.gymmanagementsystemdemo.service;

import com.gorkemkaragoz.gymmanagementsystemdemo.entity.MenuItem;

import java.util.List;

public interface IMenuItemService {

    List<MenuItem> findAll();

    MenuItem findById(Integer id);

    MenuItem save(MenuItem menuItem);

    MenuItem update(MenuItem menuItem);

    void deleteById(Integer id);
}