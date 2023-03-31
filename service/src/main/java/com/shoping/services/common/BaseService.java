package com.shoping.services.common;

import java.util.Collection;
import java.util.List;

public interface BaseService<T, ID> {
    List<T> getAll();

    T getById(ID id);

    List<T> getByIds(Collection<ID> ids);

    T createOrUpdate(ID id, T t) throws Exception;

    List<T> createOrUpdateMany(String isUorC, Collection<T> ts) throws Exception;

    boolean deleteById(ID id);

    List<T> deleteMany(Collection<ID> ids) throws Exception;
}
