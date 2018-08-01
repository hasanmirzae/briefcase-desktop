package com.github.hasanmirzae.briefcasedesktop.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private byte gender;
    @Column(unique = true)
    private String uuid;
    private String avatar;



    public Friend(String name, String lastName, String email, byte gender, String avatar, String uuid) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.avatar = avatar;
        this.uuid = uuid;
    }
}
