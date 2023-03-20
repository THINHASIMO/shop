package com.shoping.controller.order;

import com.shoping.entity.order.Order;
import com.shoping.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class OrderController {
    @Autowired
    private OrderService service;

    @PostMapping("/order")
    public Order createOrder(@RequestBody Order order) {
        return service.saveOrder(order);
    }

    @PostMapping("/orders")
    public List<Order> createOrders(@RequestBody List<Order> orders) {
        return service.saveOrders(orders);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return service.getAllOrder();
    }

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable int id) {
        return service.getOrderById(id);
    }

    @PutMapping("/order")
    public Order updateOrderByName(@RequestBody Order order) {
        return service.updateOrder(order);
    }

    @DeleteMapping("/order/{id}")
    public String deleteOrder(@PathVariable int id) {
        return service.deleteOrder(id);
    }
}
