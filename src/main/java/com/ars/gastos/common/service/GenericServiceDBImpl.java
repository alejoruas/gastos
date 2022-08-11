package com.ars.gastos.common.service;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ars.gastos.common.domain.Repository;

public abstract class GenericServiceDBImpl<T, ID extends Serializable> implements Repository<T, ID>{
    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public Optional<T> searchById(ID id) {
        return getDao().findById(id);
    }

    public abstract CrudRepository<T, ID> getDao();
}
