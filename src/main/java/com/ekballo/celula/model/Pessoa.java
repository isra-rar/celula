package com.ekballo.celula.model;

import com.ekballo.celula.model.enums.Atribuicao;
import jakarta.persistence.*;
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

    @Enumerated(EnumType.STRING)
    private Atribuicao atribuicao;

    @ManyToOne
    private Celula celula;
}
