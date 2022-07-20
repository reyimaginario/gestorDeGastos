package com.dadasoft.gestorDeGastos.service;

import com.dadasoft.gestorDeGastos.api.CategoriaApi;

import java.util.List;

public interface ICategoriaService {

	CategoriaApi agregarCategoria(CategoriaApi request);

	List<CategoriaApi> findAll();
}
