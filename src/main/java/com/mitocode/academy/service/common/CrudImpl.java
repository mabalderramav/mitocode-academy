package com.mitocode.academy.service.common;

import com.mitocode.academy.exception.ModelNotFoundException;
import com.mitocode.academy.repository.common.IGenericRepository;

import java.util.List;

public abstract class CrudImpl <T, I> implements ICrud<T, I> {
    protected abstract IGenericRepository<T, I> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(I id, T t) {
        if (!getRepo().existsById(id)) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findById(I id) {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
    }

    @Override
    public void delete(I id) {
        if (!getRepo().existsById(id)) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        }
        getRepo().deleteById(id);
    }
}
