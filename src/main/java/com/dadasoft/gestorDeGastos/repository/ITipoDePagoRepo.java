package com.dadasoft.gestorDeGastos.repository;

import com.dadasoft.gestorDeGastos.entity.catalogo.TipoDePagoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipoDePagoRepo extends JpaRepository<TipoDePagoDAO, Long> {

	List<TipoDePagoDAO> findByEnableTrue();
	TipoDePagoDAO findByDesc(String tipoDePagoDesc);

}
