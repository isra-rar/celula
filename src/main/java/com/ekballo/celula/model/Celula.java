package com.ekballo.celula.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Celula extends BaseEntity{

    private String nome;

    @ManyToOne
    private Igreja igreja;

    @OneToMany(mappedBy = "celula")
    private List<Pessoa> pessoas = new ArrayList<>();
}
