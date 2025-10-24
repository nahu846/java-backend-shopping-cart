package com.nahu846.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrudServiceImpl<T> implements CrudService<T> {
    private final Map<Long, T> storage = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public void create(T obj) {
        storage.put(nextId++, obj);
    }

    @Override
    public T read(Long id) {
        return storage.get(id);
    }

    @Override
    public List<T> readAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void update(Long id, T obj) {
        storage.put(id, obj);
    }

    @Override
    public void delete(Long id) {
        storage.remove(id);
    }
}
