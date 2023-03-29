package com.shoping.controller.common;

import com.shoping.services.common.BaseService;
import com.shoping.utils.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public abstract class BaseController<T, ID> {
    protected BaseService<T, ID> baseService;

    public BaseController(BaseService<T, ID> baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Object> getAll() {
        return ResponseHandler.generateResponse(HttpStatus.OK, "", baseService.getAll());
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") ID id) {
        return ResponseHandler.generateResponse(HttpStatus.OK, "", baseService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody T t) {
        return ResponseHandler.generateResponse(HttpStatus.CREATED, "", baseService.createOrUpdate(null, t));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") ID id,
                                         @Valid @RequestBody T t) {
        return ResponseHandler.generateResponse(HttpStatus.OK, "", baseService.createOrUpdate(id, t));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") ID id) {
        return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, "", baseService.deleteById(id));
    }
}
