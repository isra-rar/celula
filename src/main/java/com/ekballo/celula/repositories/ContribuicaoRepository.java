package com.ekballo.celula.repositories;

import com.ekballo.celula.model.Contribuicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContribuicaoRepository extends JpaRepository<Contribuicao, Long> {
}
