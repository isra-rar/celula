package com.ekballo.celula.repositories;

import com.ekballo.celula.model.Igreja;
import com.ekballo.celula.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IgrejaRepository extends JpaRepository<Igreja, Long> {
}
