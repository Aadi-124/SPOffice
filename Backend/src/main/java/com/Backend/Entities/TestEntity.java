package com.Backend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TestEntity {
    @Id
    private Long id;

    private String test;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
