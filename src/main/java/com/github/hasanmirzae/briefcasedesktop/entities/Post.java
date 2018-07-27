package com.github.hasanmirzae.briefcasedesktop.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean isMine;
    private LocalDateTime createdAt;
    private String text;
    private String attachments;
    private String poster;


    public Post(Long id, boolean isMine, LocalDateTime createdAt, String text, String attachments, String poster) {
        this.id = id;
        this.isMine = isMine;
        this.createdAt = createdAt;
        this.text = text;
        this.attachments = attachments;
        this.poster = poster;
    }
}
