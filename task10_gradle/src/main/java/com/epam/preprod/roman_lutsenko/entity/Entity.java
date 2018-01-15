package com.epam.preprod.roman_lutsenko.entity;

/**
 * Base entity for with id definition
 */
public abstract class Entity {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
