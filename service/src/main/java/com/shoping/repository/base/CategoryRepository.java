package com.shoping.repository.base;

import com.shoping.entity.base.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
//    Product findByName(String name);
}
