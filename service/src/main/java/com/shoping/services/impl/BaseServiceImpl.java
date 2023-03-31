package com.shoping.services.impl;

import com.shoping.entity.common.BaseEntity;
import com.shoping.services.common.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public class BaseServiceImpl<T extends BaseEntity, ID> implements BaseService<T, ID> {
    private static final Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);
    protected JpaRepository<T, ID> repository;

    public BaseServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return this.repository.findAll();
    }

    public T getById(ID id) {
        T t = (T) this.repository.findById(id).orElse(null);
        return t;
    }

    public List<T> getByIds(Collection<ID> ids) {
        return this.repository.findAllById(ids);
    }

    @Transactional
    public T createOrUpdate(ID id, T t) {
        if (id != null) {
            T e = this.getById(id);
            if (e != null) {
                BeanUtils.copyProperties(t, e, getNullPropertyNames(t));
                return (T) this.repository.save(e);
            } else {
                return null;
            }
        } else {
            return (T) this.repository.save(t);
        }
    }

    @Override
    public List<T> createOrUpdateMany(String isCorU, Collection<T> ts) throws Exception {
        try {
            if (isCorU.equals("update")) {
                List<Long> listIds = new ArrayList<Long>();
                List<T> es = new ArrayList<T>();

                ts.forEach(data -> {
                    if (data.getId() != null) {
                        listIds.add(data.getId());
                    }
                });

                if (listIds.size() > 0) {
                    es = this.getByIds((List<ID>) listIds);
                    if (es.size() > 0) {
                        es.forEach(e -> {
                            ts.forEach(t -> {
                                if (e.getId().equals(t.getId())) {
                                    BeanUtils.copyProperties(t, e, getNullPropertyNames(t));
                                    this.repository.save(e);
                                }
                            });
                        });
                    }
                }
            } else {
                this.repository.saveAll(ts);
            }
            return (List<T>) ts;
        } catch (Exception e) {
            //  Block of code to handle errors
            System.out.println("ERROR: createOrUpdateMany" + e);
            return (List<T>) ts;
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

    @Override
    public List<T> deleteMany(Collection<ID> ids) throws Exception {
        try {
            List<T> temp = new ArrayList<T>();
            List<T> ts = this.getByIds(ids);
            ts.forEach(t -> {
                t.setDeleted(true);
                temp.add(t);
            });
            this.repository.saveAll(temp);
            return (List<T>) temp;
        } catch (Exception var3) {
            return null;
        }
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }


}
