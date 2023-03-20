package com.shoping.services.order;

import com.shoping.entity.order.Order;
import com.shoping.entity.product.Product;
import com.shoping.repository.order.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Order saveOrder(Order order) {
        return repository.save(order);
    }

    public List<Order> saveOrders(List<Order> orders) {
        return repository.saveAll(orders);
    }

    public List<Order> getAllOrder() {
        return repository.findAll();
    }

    public Order getOrderById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteOrder(int id) {
        repository.deleteById(id);
        return "order is deleted" + id;
    }

    public Order updateOrder(Order order) {
        Order exitsOrder = repository.findById(order.getId()).orElse(null);
//        exitsProduct.setName(product.getName());
//        exitsProduct.setPrice(product.getPrice());
//        exitsProduct.setPrice(product.getQuantity());
//        return repository.save(exitsProduct);
        return null;
    }
}
