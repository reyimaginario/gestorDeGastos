package com.dadasoft.gestorDeGastos.service;

import com.dadasoft.gestorDeGastos.api.MovimientoApi;

import java.util.List;

public interface IMovimientoService {

	MovimientoApi agregarMovimiento(MovimientoApi request);

	List<MovimientoApi> findAll();
}
