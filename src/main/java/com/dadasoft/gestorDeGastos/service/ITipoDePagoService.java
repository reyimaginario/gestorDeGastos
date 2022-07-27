package com.dadasoft.gestorDeGastos.service;

import com.dadasoft.gestorDeGastos.api.catalogo.TipoDePagoApi;
import com.dadasoft.gestorDeGastos.exception.TipoDePagoException;

import java.util.List;

public interface ITipoDePagoService {

	List<TipoDePagoApi> obtenerTiposDePagoHabilitados();

	List<TipoDePagoApi> findAll();

	TipoDePagoApi agregarTipoDePago(TipoDePagoApi request);


	TipoDePagoApi deshabilitarTipoDePago(String id) throws TipoDePagoException;

	TipoDePagoApi updateTipoDePago(TipoDePagoApi request) throws TipoDePagoException;
}
