package com.shoping.services;

import com.shoping.entity.UserEntity;
import com.shoping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    @Autowired
    private UserRepository repository;

    public UserEntity saveUser(UserEntity userEntity) {
        return repository.save(userEntity);
    }

    public List<UserEntity> saveUsers(List<UserEntity> userEntities) {
        return repository.saveAll(userEntities);
    }

    public List<UserEntity> getAllUser() {
        return repository.findAll();
    }

    public UserEntity getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteUser(int id) {
        repository.deleteById(id);
        return "user is deleted" + id;
    }

    public UserEntity updateUser(UserEntity userEntity) {
        UserEntity exitsUserEntity = repository.findById(userEntity.getId()).orElse(null);
//        exitsProduct.setName(product.getName());
//        exitsProduct.setPrice(product.getPrice());
//        exitsProduct.setPrice(product.getQuantity());
//        return repository.save(exitsProduct);
        return null;
    }
}
