package com.dadasoft.gestorDeGastos.repository;

import com.dadasoft.gestorDeGastos.entity.CategoriaDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepo extends JpaRepository<CategoriaDAO, Long> {
}
