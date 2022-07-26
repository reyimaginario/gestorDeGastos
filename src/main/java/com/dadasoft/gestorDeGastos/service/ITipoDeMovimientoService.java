package com.dadasoft.gestorDeGastos.service;

import com.dadasoft.gestorDeGastos.api.catalogo.TipoDeMovimientoApi;

import java.util.List;

public interface ITipoDeMovimientoService {

	TipoDeMovimientoApi agregarTipoDeMovimiento(TipoDeMovimientoApi request);

	List<TipoDeMovimientoApi> findAll();
}
