package com.shoping.controller;

import com.shoping.entity.CategoryEntity;
import com.shoping.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping("/category")
    public CategoryEntity createCategory(@RequestBody CategoryEntity categoryEntity) {
        return service.saveCategory(categoryEntity);
    }

    @PostMapping("/categories")
    public List<CategoryEntity> createCategorys(@RequestBody List<CategoryEntity> categories) {
        return service.saveCategories(categories);
    }

    @GetMapping("/categories")
    public List<CategoryEntity> getAllCategories() {
        return service.getAllCategory();
    }

    @GetMapping("/category/{id}")
    public CategoryEntity getCategoryById(@PathVariable int id) {
        return service.getCategoryById(id);
    }

    @PutMapping("/category")
    public CategoryEntity updateCategoryByName(@RequestBody CategoryEntity categoryEntity) {
        return service.updateCategory(categoryEntity);
    }

    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable int id) {
        return service.deleteCategory(id);
    }
}
