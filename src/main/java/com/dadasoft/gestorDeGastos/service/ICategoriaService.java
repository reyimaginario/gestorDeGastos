package com.dadasoft.gestorDeGastos.service;

import com.dadasoft.gestorDeGastos.api.CategoriaApi;
import com.dadasoft.gestorDeGastos.exception.CategoriaException;

import java.util.List;

public interface ICategoriaService {

	List<CategoriaApi> obtenerCategoriasHabilitadas();

	CategoriaApi agregarCategoria(CategoriaApi request);

	List<CategoriaApi> findAll();

	CategoriaApi deshabilitarCategoria(String id) throws CategoriaException;
}
