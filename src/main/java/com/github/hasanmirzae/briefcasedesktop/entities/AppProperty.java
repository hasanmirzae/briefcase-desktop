package com.github.hasanmirzae.briefcasedesktop.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AppProperty {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(unique = true)
    private String name;
    private String value;

    public AppProperty() {
    }

    public AppProperty(Long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }
}
