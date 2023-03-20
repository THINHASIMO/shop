package com.shoping.repository.cart;
import com.shoping.entity.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
//    Product findByName(String name);
}
