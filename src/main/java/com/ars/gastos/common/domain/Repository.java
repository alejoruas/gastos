package com.ars.gastos.common.domain;

import java.io.Serializable;
import java.util.Optional;

public interface Repository<T, ID extends Serializable> {
    T save(T entity);

    Optional<T> searchById(ID id);
}
