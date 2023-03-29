package com.shoping.controller;

import com.shoping.entity.OrderEntity;
import com.shoping.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("/order")
    public OrderEntity createOrder(@RequestBody OrderEntity orderEntity) {
        return service.saveOrder(orderEntity);
    }

    @PostMapping("/orders")
    public List<OrderEntity> createOrders(@RequestBody List<OrderEntity> orderEntities) {
        return service.saveOrders(orderEntities);
    }

    @GetMapping("/orders")
    public List<OrderEntity> getAllOrders() {
        return service.getAllOrder();
    }

    @GetMapping("/order/{id}")
    public OrderEntity getOrderById(@PathVariable int id) {
        return service.getOrderById(id);
    }

    @PutMapping("/order")
    public OrderEntity updateOrderByName(@RequestBody OrderEntity orderEntity) {
        return service.updateOrder(orderEntity);
    }

    @DeleteMapping("/order/{id}")
    public String deleteOrder(@PathVariable int id) {
        return service.deleteOrder(id);
    }
}
