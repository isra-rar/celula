package com.ekballo.celula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pessoa extends BaseEntity {

    private String nome;
    private String telefone;
    private boolean hasCelula;

    @ManyToOne
    private Celula celula;
}
