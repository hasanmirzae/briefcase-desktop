package com.github.hasanmirzae.briefcasedesktop.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String gender;
    private boolean isMine;
    private String status;
    private String uuid;


    public Request(Long id, String name, String lastName, String email, String gender, boolean isMine, String status, String uuid) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.isMine = isMine;
        this.status = status;
        this.uuid = uuid;
    }
}
