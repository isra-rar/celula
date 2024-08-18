package com.ekballo.celula.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Igreja extends BaseEntity {

    private String nome;
}
