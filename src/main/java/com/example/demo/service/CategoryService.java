package com.example.demo.service;

import com.example.demo.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category saveOrUpdate(Category category);
    Category findById(Long id);
    void delete(Long id);
}
