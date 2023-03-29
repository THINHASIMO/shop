package com.shoping.repository;
import com.shoping.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
//    Product findByName(String name);
}
