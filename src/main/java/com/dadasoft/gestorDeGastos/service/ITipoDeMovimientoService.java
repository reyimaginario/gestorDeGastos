package com.dadasoft.gestorDeGastos.service;

import com.dadasoft.gestorDeGastos.api.catalogo.TipoDeMovimientoApi;
import com.dadasoft.gestorDeGastos.exception.TipoDeMovimientoException;

import java.util.List;

public interface ITipoDeMovimientoService {

	List<TipoDeMovimientoApi> obtenerTiposDeMovimientoHabilitados();

	List<TipoDeMovimientoApi> findAll();

	TipoDeMovimientoApi agregarTipoDeMovimiento(TipoDeMovimientoApi request);

	TipoDeMovimientoApi deshabilitarTipoDeMovimiento(String id) throws TipoDeMovimientoException;

	TipoDeMovimientoApi actualizarTipoDeMovimiento(TipoDeMovimientoApi request) throws TipoDeMovimientoException;
}
