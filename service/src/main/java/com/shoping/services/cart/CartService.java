package com.shoping.services.cart;

import com.shoping.entity.cart.Cart;
import com.shoping.entity.product.Product;
import com.shoping.repository.cart.CartRepository;
import com.shoping.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartService {
    @Autowired
    private CartRepository repository;

    public Cart saveCart(Cart cart) {
        return repository.save(cart);
    }

    public List<Cart> saveCarts(List<Cart> carts) {
        return repository.saveAll(carts);
    }

    public List<Cart> getAllCart() {
        return repository.findAll();
    }

    public Cart getCartById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteCart(int id) {
        repository.deleteById(id);
        return "product is deleted" + id;
    }

    public Cart updateCart(Cart cart) {
        Cart exitsCart = repository.findById(cart.getId()).orElse(null);
//        exitsProduct.setName(product.getName());
//        exitsProduct.setPrice(product.getPrice());
//        exitsProduct.setPrice(product.getQuantity());
//        return repository.save(exitsProduct);
        return null;
    }
}
