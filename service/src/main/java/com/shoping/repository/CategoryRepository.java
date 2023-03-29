package com.shoping.repository;

import com.shoping.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
//    Product findByName(String name);
}
