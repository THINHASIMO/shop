package com.shoping.controller.cart;

import com.shoping.entity.cart.Cart;
import com.shoping.services.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CartController {
    @Autowired
    private CartService service;

    @PostMapping("/cart")
    public Cart createCart(@RequestBody Cart cart) {
        return service.saveCart(cart);
    }

    @PostMapping("/cart")
    public List<Cart> createOrders(@RequestBody List<Cart> carts) {
        return service.saveCarts(carts);
    }

    @GetMapping("/cart")
    public List<Cart> getAllCarts() {
        return service.getAllCart();
    }

    @GetMapping("/cart/{id}")
    public Cart getOrderById(@PathVariable int id) {
        return service.getCartById(id);
    }

    @PutMapping("/cart")
    public Cart updateCartByName(@RequestBody Cart cart) {
        return service.updateCart(cart);
    }

    @DeleteMapping("/cart/{id}")
    public String deleteCart(@PathVariable int id) {
        return service.deleteCart(id);
    }
}
