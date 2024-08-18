package com.ekballo.celula.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.time.LocalDateTime;


@MappedSuperclass
@Getter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime created_at = LocalDateTime.now();
    private LocalDateTime updated_at;

    protected void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

}
