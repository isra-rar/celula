package com.ekballo.celula.repositories;

import com.ekballo.celula.model.Celula;
import com.ekballo.celula.model.Igreja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelulaRepository extends JpaRepository<Celula, Long> {
}
