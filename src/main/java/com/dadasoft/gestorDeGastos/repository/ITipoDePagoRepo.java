package com.dadasoft.gestorDeGastos.repository;

import com.dadasoft.gestorDeGastos.entity.catalogo.TipoDePagoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoDePagoRepo extends JpaRepository<TipoDePagoDAO, Long> {
	TipoDePagoDAO findByDesc(String tipoDePagoDesc);
}
