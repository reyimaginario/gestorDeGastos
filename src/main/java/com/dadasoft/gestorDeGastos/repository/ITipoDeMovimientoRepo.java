package com.dadasoft.gestorDeGastos.repository;

import com.dadasoft.gestorDeGastos.entity.TipoDeMovimientoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoDeMovimientoRepo extends JpaRepository<TipoDeMovimientoDAO, Long> {
}
