package com.shoping.services.base;

import com.shoping.entity.base.Category;
import com.shoping.repository.base.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    public List<Category> saveCategories(List<Category> products) {
        return repository.saveAll(products);
    }

    public List<Category> getAllCategory() {
        return repository.findAll();
    }

    public Category getCategoryById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteCategory(int id) {
        repository.deleteById(id);
        return "category is deleted" + id;
    }

    public Category updateCategory(Category category) {
        Category exitsCategory = repository.findById(category.getId()).orElse(null);
//        exitsProduct.setName(category.getName());
//        exitsProduct.setPrice(category.getPrice());
//        exitsProduct.setPrice(category.getQuantity());
//        return repository.save(exitsProduct);
        return null;
    }
}
