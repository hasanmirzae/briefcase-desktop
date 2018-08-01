package com.github.hasanmirzae.briefcasedesktop.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean isMine;
    private LocalDateTime createdAt;
    private String text;
    private String attachments;
    private String commenterUuid;
    private Long postId;

    public PostComment(Long id, boolean isMine, LocalDateTime createdAt, String text, String attachments, String commenterUuid, Long postId) {
        this.id = id;
        this.isMine = isMine;
        this.createdAt = createdAt;
        this.text = text;
        this.attachments = attachments;
        this.commenterUuid = commenterUuid;
        this.postId = postId;
    }
}
