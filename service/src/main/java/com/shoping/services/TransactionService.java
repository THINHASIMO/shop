package com.shoping.services;

import com.shoping.entity.TransactionEntity;
import com.shoping.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public TransactionEntity saveTransaction(TransactionEntity transactionEntity) {
        return repository.save(transactionEntity);
    }

    public List<TransactionEntity> saveTransactions(List<TransactionEntity> transactionEntities) {
        return repository.saveAll(transactionEntities);
    }

    public List<TransactionEntity> getAllTransactions() {
        return repository.findAll();
    }

    public TransactionEntity getTransactionById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteTransaction(int id) {
        repository.deleteById(id);
        return "transaction is deleted" + id;
    }

    public TransactionEntity updateTransaction(TransactionEntity transactionEntity) {
        TransactionEntity exitsTransactionEntity = repository.findById(transactionEntity.getId()).orElse(null);
//        exitsProduct.setName(transaction.getName());
//        exitsProduct.setPrice(transaction.getPrice());
//        exitsProduct.setPrice(transaction.getQuantity());
//        return repository.save(exitsProduct);
        return null;
    }
}
