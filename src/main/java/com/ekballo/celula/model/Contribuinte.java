package com.ekballo.celula.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contribuinte extends BaseEntity {

    @OneToOne
    private Pessoa pessoa;
    private BigDecimal valorContribuido;
    private boolean hasContribuiu;

    @ManyToOne
    private Contribuicao contribuicao;
}
