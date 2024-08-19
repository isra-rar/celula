package com.ekballo.celula.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa extends BaseEntity {

    private String nome;
    private String telefone;

    @Embedded
    private Endereco endereco;

    private boolean hasCelula;

    @ManyToOne
    private Celula celula;
}
