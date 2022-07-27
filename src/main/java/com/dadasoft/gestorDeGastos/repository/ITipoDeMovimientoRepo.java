package com.dadasoft.gestorDeGastos.repository;

import com.dadasoft.gestorDeGastos.entity.catalogo.TipoDeMovimientoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITipoDeMovimientoRepo extends JpaRepository<TipoDeMovimientoDAO, Long> {

	List<TipoDeMovimientoDAO> findByEnableTrue();
	TipoDeMovimientoDAO findByDesc(String tipoDeMovimientoDesc);
}
