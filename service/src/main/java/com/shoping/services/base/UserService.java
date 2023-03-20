package com.shoping.services.base;

import com.shoping.entity.base.User;
import com.shoping.entity.product.Product;
import com.shoping.repository.base.UserRepository;
import com.shoping.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users) {
        return repository.saveAll(users);
    }

    public List<User> getAllUser() {
        return repository.findAll();
    }

    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteUser(int id) {
        repository.deleteById(id);
        return "user is deleted" + id;
    }

    public User updateUser(User user) {
        User exitsUser = repository.findById(user.getId()).orElse(null);
//        exitsProduct.setName(product.getName());
//        exitsProduct.setPrice(product.getPrice());
//        exitsProduct.setPrice(product.getQuantity());
//        return repository.save(exitsProduct);
        return null;
    }
}
