package com.shoping.services;

import com.shoping.entity.CategoryEntity;
import com.shoping.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public CategoryEntity saveCategory(CategoryEntity categoryEntity) {
        return repository.save(categoryEntity);
    }

    public List<CategoryEntity> saveCategories(List<CategoryEntity> products) {
        return repository.saveAll(products);
    }

    public List<CategoryEntity> getAllCategory() {
        return repository.findAll();
    }

    public CategoryEntity getCategoryById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteCategory(int id) {
        repository.deleteById(id);
        return "category is deleted" + id;
    }

    public CategoryEntity updateCategory(CategoryEntity categoryEntity) {
        CategoryEntity exitsCategoryEntity = repository.findById(categoryEntity.getId()).orElse(null);
//        exitsProduct.setName(category.getName());
//        exitsProduct.setPrice(category.getPrice());
//        exitsProduct.setPrice(category.getQuantity());
//        return repository.save(exitsProduct);
        return null;
    }
}
