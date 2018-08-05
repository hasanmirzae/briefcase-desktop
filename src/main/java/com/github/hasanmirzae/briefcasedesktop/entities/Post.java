package com.github.hasanmirzae.briefcasedesktop.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("isMine")
    private boolean isMine;
    private LocalDateTime createdAt;
    private String text;
    private String attachments;
    private String posterUuid;
    private Long remoteId;
    private String uuid;

    public Post(Long id, String uuid, boolean isMine, LocalDateTime createdAt, String text, String attachments, String posterUuid, Long remoteId) {
        this.id = id;
        this.isMine = isMine;
        this.createdAt = createdAt;
        this.text = text;
        this.attachments = attachments;
        this.posterUuid = posterUuid;
        this.remoteId = remoteId;
        this.uuid = uuid;
    }
}
