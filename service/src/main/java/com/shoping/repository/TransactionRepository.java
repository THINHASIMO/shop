package com.shoping.repository;
import com.shoping.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Integer> {
//    Product findByName(String name);
}
