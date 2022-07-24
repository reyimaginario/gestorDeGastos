package com.dadasoft.gestorDeGastos.service;

import com.dadasoft.gestorDeGastos.api.MovimientoApi;
import com.dadasoft.gestorDeGastos.exception.CategoriaException;
import com.dadasoft.gestorDeGastos.exception.TipoDeMovimientoException;
import com.dadasoft.gestorDeGastos.exception.TipoDePagoException;

import java.util.List;

public interface IMovimientoService {

	MovimientoApi agregarMovimiento(MovimientoApi request) throws TipoDeMovimientoException, CategoriaException, TipoDePagoException;

	List<MovimientoApi> findAll();
}
