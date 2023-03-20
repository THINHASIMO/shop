package com.shoping.controller.base;

import com.shoping.entity.base.Transaction;
import com.shoping.services.base.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping("/transaction")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return service.saveTransaction(transaction);
    }

    @PostMapping("/transactions")
    public List<Transaction> createTransactions(@RequestBody List<Transaction> transactions) {
        return service.saveTransactions(transactions);
    }

    @GetMapping("/transaction")
    public List<Transaction> getAllTransactions() {
        return service.getAllTransactions();
    }

    @GetMapping("/transaction/{id}")
    public Transaction getTransactionById(@PathVariable int id) {
        return service.getTransactionById(id);
    }

    @PutMapping("/transaction")
    public Transaction updateTransactionByName(@RequestBody Transaction transaction) {
        return service.updateTransaction(transaction);
    }

    @DeleteMapping("/transaction/{id}")
    public String deleteTransaction(@PathVariable int id) {
        return service.deleteTransaction(id);
    }
}
