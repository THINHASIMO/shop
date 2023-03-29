package com.shoping.controller;

import com.shoping.entity.TransactionEntity;
import com.shoping.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping("/transaction")
    public TransactionEntity createTransaction(@RequestBody TransactionEntity transactionEntity) {
        return service.saveTransaction(transactionEntity);
    }

    @PostMapping("/transactions")
    public List<TransactionEntity> createTransactions(@RequestBody List<TransactionEntity> transactionEntities) {
        return service.saveTransactions(transactionEntities);
    }

    @GetMapping("/transaction")
    public List<TransactionEntity> getAllTransactions() {
        return service.getAllTransactions();
    }

    @GetMapping("/transaction/{id}")
    public TransactionEntity getTransactionById(@PathVariable int id) {
        return service.getTransactionById(id);
    }

    @PutMapping("/transaction")
    public TransactionEntity updateTransactionByName(@RequestBody TransactionEntity transactionEntity) {
        return service.updateTransaction(transactionEntity);
    }

    @DeleteMapping("/transaction/{id}")
    public String deleteTransaction(@PathVariable int id) {
        return service.deleteTransaction(id);
    }
}
