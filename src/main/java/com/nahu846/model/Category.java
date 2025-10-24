package com.nahu846.model;

import lombok.*;

import java.util.List;

@Data
public class Category {
    private Long id;
    private String name;

    private List<Product> products;

    public Category(String name) {
        this.name = name;
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
