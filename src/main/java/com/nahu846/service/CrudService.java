package com.nahu846.service;

import java.util.List;

public interface CrudService<T> {
    void create(T obj);
    T read(Long id);
    List<T> readAll();
    void update(Long id, T obj);
    void delete(Long id);
}
