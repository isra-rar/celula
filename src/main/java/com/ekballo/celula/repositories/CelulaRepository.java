package com.ekballo.celula.repositories;

import com.ekballo.celula.model.Celula;
import com.ekballo.celula.model.enums.DiaSemana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface CelulaRepository extends JpaRepository<Celula, Long> {

    List<Celula> findByDiaSemana(DiaSemana diaSemana);
}
