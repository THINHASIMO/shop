package com.shoping.repository.base;
import com.shoping.entity.base.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
//    Product findByName(String name);
}
