package com.shoping.repository.product;

import com.shoping.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
//    Product findByName(String name);
}
