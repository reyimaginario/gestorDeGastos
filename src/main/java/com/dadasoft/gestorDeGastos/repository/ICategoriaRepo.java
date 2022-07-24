package com.dadasoft.gestorDeGastos.repository;

import com.dadasoft.gestorDeGastos.entity.catalogo.CategoriaDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICategoriaRepo extends JpaRepository<CategoriaDAO, Long> {

	List<CategoriaDAO> findByEnableTrue();
	CategoriaDAO findByDesc(String categoriaDesc);

	Optional<CategoriaDAO> findById(Long id);
}
