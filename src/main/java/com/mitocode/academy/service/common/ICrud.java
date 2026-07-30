package com.mitocode.academy.service.common;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ICrud <T, I> {

    T save(T t);
    T update(I id, T t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
    List<T> findAll();
    T findById(I id);
    void delete(I id);
}
