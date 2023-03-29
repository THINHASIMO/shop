package com.shoping.controller;

import com.shoping.entity.CartEntity;
import com.shoping.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CartController {
    @Autowired
    private CartService service;

    @PostMapping("/cart")
    public CartEntity createCart(@RequestBody CartEntity cartEntity) {
        return service.saveCart(cartEntity);
    }

    @PostMapping("/cart")
    public List<CartEntity> createOrders(@RequestBody List<CartEntity> cartEntities) {
        return service.saveCarts(cartEntities);
    }

    @GetMapping("/cart")
    public List<CartEntity> getAllCarts() {
        return service.getAllCart();
    }

    @GetMapping("/cart/{id}")
    public CartEntity getOrderById(@PathVariable int id) {
        return service.getCartById(id);
    }

    @PutMapping("/cart")
    public CartEntity updateCartByName(@RequestBody CartEntity cartEntity) {
        return service.updateCart(cartEntity);
    }

    @DeleteMapping("/cart/{id}")
    public String deleteCart(@PathVariable int id) {
        return service.deleteCart(id);
    }
}
