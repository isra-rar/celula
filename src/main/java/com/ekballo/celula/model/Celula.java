package com.ekballo.celula.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Celula extends BaseEntity {

    private String nome;

    @ManyToOne
    private Igreja igreja;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "celula")
    private List<Pessoa> pessoas = new ArrayList<>();

    public void adicionarPessoaCelula(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }
}
