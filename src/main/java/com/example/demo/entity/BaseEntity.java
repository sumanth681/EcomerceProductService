package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.yaml.snakeyaml.events.Event;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdBy;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private Instant updatedBy;


    @PrePersist
    public void onCreate() {
        Instant now  = Instant.now();
        this.createdBy = now;
        this.updatedBy = now;
    }
    @PreUpdate
    public void onUpdate() {
        this.updatedBy = Instant.now();
    }
}
