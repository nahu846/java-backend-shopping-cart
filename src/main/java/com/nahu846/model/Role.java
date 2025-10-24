package com.nahu846.model;

import lombok.Data;

import java.util.Collection;
import java.util.HashSet;

@Data
public class Role {
    private Long id;
    private String name;

    private Collection<User> users = new HashSet<>();

    public Role(String name) {
        this.name = name;
    }
}
