package com.dadasoft.gestorDeGastos.repository;

import com.dadasoft.gestorDeGastos.entity.MovimientoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovimientoRepo extends JpaRepository<MovimientoDAO, Long> {
}
