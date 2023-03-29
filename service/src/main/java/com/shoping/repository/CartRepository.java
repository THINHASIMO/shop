package com.shoping.repository;
import com.shoping.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity,Integer> {
//    Product findByName(String name);
}
