package com.shoping.repository.base;
import com.shoping.entity.base.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
//    Product findByName(String name);
}
