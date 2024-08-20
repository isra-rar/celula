package com.ekballo.celula.model;

import com.ekballo.celula.model.enums.DiaSemana;
import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
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

    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;
    private LocalTime horario;

    @OneToMany(mappedBy = "celula")
    private List<Pessoa> pessoas = new ArrayList<>();

    public void adicionarPessoaCelula(Pessoa pessoa) {
        this.pessoas.add(pessoa);
    }
}
