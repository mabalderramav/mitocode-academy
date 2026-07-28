package com.mitocode.academy.service.common;

import com.mitocode.academy.exception.ModelNotFoundException;
import com.mitocode.academy.repository.common.IGenericRepository;

import java.util.List;

public abstract class CrudImpl <T, I> implements ICrud<T, I> {

    public static final String ID_NOT_FOUND = "ID NOT FOUND: ";

    protected abstract IGenericRepository<T, I> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(I id, T t) {
        if (!getRepo().existsById(id)) {
            throw new ModelNotFoundException(ID_NOT_FOUND.concat(String.valueOf(id)));
        }
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findById(I id) {
        return getRepo()
                .findById(id)
                .orElseThrow(() -> new ModelNotFoundException(ID_NOT_FOUND.concat(String.valueOf(id))));
    }

    @Override
    public void delete(I id) {
        if (!getRepo().existsById(id)) {
            throw new ModelNotFoundException(ID_NOT_FOUND.concat(String.valueOf(id)));
        }
        getRepo().deleteById(id);
    }
}
