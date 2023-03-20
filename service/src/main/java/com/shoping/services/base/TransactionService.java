package com.shoping.services.base;

import com.shoping.entity.base.Transaction;
import com.shoping.repository.base.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public Transaction saveTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> saveTransactions(List<Transaction> transactions) {
        return repository.saveAll(transactions);
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Transaction getTransactionById(int id) {
        return repository.findById(id).orElse(null);
    }

    public String deleteTransaction(int id) {
        repository.deleteById(id);
        return "transaction is deleted" + id;
    }

    public Transaction updateTransaction(Transaction transaction) {
        Transaction exitsTransaction = repository.findById(transaction.getId()).orElse(null);
//        exitsProduct.setName(transaction.getName());
//        exitsProduct.setPrice(transaction.getPrice());
//        exitsProduct.setPrice(transaction.getQuantity());
//        return repository.save(exitsProduct);
        return null;
    }
}
