package com.ekballo.celula.repositories;

import com.ekballo.celula.model.Contribuinte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContribuinteRepository extends JpaRepository<Contribuinte, Long> {
}
