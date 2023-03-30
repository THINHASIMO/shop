package com.shoping.services.impl;

import com.shoping.entity.common.BaseEntity;
import com.shoping.repository.ProductRepository;
import com.shoping.services.common.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

public class BaseServiceImpl<T extends BaseEntity, ID> implements BaseService<T, ID> {
    private static final Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);
    protected JpaRepository<T, ID> repository;

    public BaseServiceImpl(ProductRepository repository) {
        this.repository = (JpaRepository<T, ID>) repository;
    }

    public List<T> getAll() {
        return this.repository.findAll();
    }

    public T getById(ID id) {
        T t = (T) this.repository.findById(id).orElseGet(() -> {
            return null;
        });
        return t != null && !t.isDeleted() ? t : null;
    }

    public List<T> getByIds(Collection<ID> ids) {
        return this.repository.findAllById(ids);
    }

    @Override
    public T createOrUpdate (ID id, T t) {
        if (id != null) {
            T e = this.getById(id);
            if (e != null) {
                return (T) this.repository.save(e);
            } else {
                return null;
            }
        } else {
            return (T) this.repository.save(t);
        }
    }

    public boolean deleteById(ID id) {
        try {
            T t = this.getById(id);
            t.setDeleted(true);
            this.repository.save(t);
            return true;
        } catch (Exception var3) {
            return false;
        }
    }
}
