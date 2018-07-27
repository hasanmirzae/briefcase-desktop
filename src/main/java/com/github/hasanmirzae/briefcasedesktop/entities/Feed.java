package com.github.hasanmirzae.briefcasedesktop.entities;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private String data;
    private String receivers;
    private String exclude;


    public Feed(Long id, String name, LocalDateTime createdAt, String data, String receivers, String exclude) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.data = data;
        this.receivers = receivers;
        this.exclude = exclude;
    }
}
