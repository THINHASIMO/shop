package com.shoping.controller.base;

import com.shoping.entity.base.Category;
import com.shoping.services.base.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category) {
        return service.saveCategory(category);
    }

    @PostMapping("/categories")
    public List<Category> createCategorys(@RequestBody List<Category> categories) {
        return service.saveCategories(categories);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return service.getAllCategory();
    }

    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return service.getCategoryById(id);
    }

    @PutMapping("/category")
    public Category updateCategoryByName(@RequestBody Category category) {
        return service.updateCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable int id) {
        return service.deleteCategory(id);
    }
}
