package com.shoping.repository.order;

import com.shoping.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
//    Product findByName(String name);
}