package com.shoping.services;

import com.shoping.entity.OrderEntity;
import com.shoping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService {
    @Autowired
    private OrderRepository repository;

    public OrderEntity saveOrder(OrderEntity orderEntity) {
        return repository.save(orderEntity);
    }

    public List<OrderEntity> saveOrders(List<OrderEntity> orderEntities) {
        return repository.saveAll(orderEntities);
    }

    public List<OrderEntity> getAllOrder() {
        return repository.findAll();
    }

    public OrderEntity getOrderById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteOrder(int id) {
        repository.deleteById(id);
        return "order is deleted" + id;
    }

    public OrderEntity updateOrder(OrderEntity orderEntity) {
        OrderEntity exitsOrderEntity = repository.findById(orderEntity.getId()).orElse(null);
//        exitsProduct.setName(product.getName());
//        exitsProduct.setPrice(product.getPrice());
//        exitsProduct.setPrice(product.getQuantity());
//        return repository.save(exitsProduct);
        return null;
    }
}
