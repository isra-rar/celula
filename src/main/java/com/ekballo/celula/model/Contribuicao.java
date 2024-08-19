package com.ekballo.celula.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contribuicao extends BaseEntity {

    @ManyToOne
    private Celula celula;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCelula;

    @OneToMany(mappedBy = "contribuicao")
    private List<Contribuinte> contribuintes = new ArrayList<>();

    private BigDecimal valorArrecadado = BigDecimal.ZERO;
}
