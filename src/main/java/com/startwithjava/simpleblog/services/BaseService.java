package com.startwithjava.simpleblog.services;

import com.startwithjava.simpleblog.entities.AbstractEntity;

import java.util.List;
public interface BaseService<T> {
    public List<T> findAll(int limit);
    public T findById(Long id);
    public Long saveOrUpdate(T entity);
}
