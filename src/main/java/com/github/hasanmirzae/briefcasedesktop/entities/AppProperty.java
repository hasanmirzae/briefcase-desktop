package com.github.hasanmirzae.briefcasedesktop.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class AppProperty {
    @Id
    @GeneratedValue
    private final Long id;
    private final String name;
    private final String value;


    public AppProperty(Long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }
}
