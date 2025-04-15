package com.gorkemkaragoz.gymmanagementsystemdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gorkemkaragoz.gymmanagementsystemdemo.entity.MenuItem;

public interface IMenuItemRepository extends JpaRepository<MenuItem, Integer> {
}
