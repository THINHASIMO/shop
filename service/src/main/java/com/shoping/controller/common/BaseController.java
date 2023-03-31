package com.shoping.controller.common;

import com.shoping.services.common.BaseService;
import com.shoping.utils.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

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
    public ResponseEntity<Object> create(@Valid @RequestBody T t) throws Exception {
        return ResponseHandler.generateResponse(HttpStatus.CREATED, "", baseService.createOrUpdate(null, t));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") ID id,
                                         @Valid @RequestBody T t) throws Exception {
        return ResponseHandler.generateResponse(HttpStatus.OK, "", baseService.createOrUpdate(id, t));
    }

    @PostMapping("/create-many")
    public ResponseEntity<Object> createMany(@Valid @RequestBody Collection<T> ts) throws Exception {
        return ResponseHandler.generateResponse(HttpStatus.CREATED, "", baseService.createOrUpdateMany("create", ts));
    }

    @PostMapping("/update-many")
    public ResponseEntity<Object> updateMany(@Valid @RequestBody Collection<T> ts) throws Exception {
        return ResponseHandler.generateResponse(HttpStatus.OK, "", baseService.createOrUpdateMany("update", ts));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") ID id) {
        return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, "", baseService.deleteById(id));
    }

    @PostMapping("/delete-many")
    public ResponseEntity<Object> deleteMany(@Valid @RequestBody Collection<ID> ids) throws Exception {
        return ResponseHandler.generateResponse(HttpStatus.ACCEPTED, "", baseService.deleteMany(ids));
    }
}
