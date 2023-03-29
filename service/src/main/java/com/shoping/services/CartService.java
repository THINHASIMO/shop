package com.shoping.services;

import com.shoping.entity.CartEntity;
import com.shoping.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartService {
    @Autowired
    private CartRepository repository;

    public CartEntity saveCart(CartEntity cartEntity) {
        return repository.save(cartEntity);
    }

    public List<CartEntity> saveCarts(List<CartEntity> cartEntities) {
        return repository.saveAll(cartEntities);
    }

    public List<CartEntity> getAllCart() {
        return repository.findAll();
    }

    public CartEntity getCartById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteCart(int id) {
        repository.deleteById(id);
        return "product is deleted" + id;
    }

    public CartEntity updateCart(CartEntity cartEntity) {
        CartEntity exitsCartEntity = repository.findById(cartEntity.getId()).orElse(null);
//        exitsProduct.setName(product.getName());
//        exitsProduct.setPrice(product.getPrice());
//        exitsProduct.setPrice(product.getQuantity());
//        return repository.save(exitsProduct);
        return null;
    }
}
