package com.shoping.repository;

import com.shoping.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {
//    Product findByName(String name);
}
