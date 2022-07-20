package com.dadasoft.gestorDeGastos.service;

import com.dadasoft.gestorDeGastos.api.TipoDePagoApi;

import java.util.List;

public interface ITipoDePagoService {

	TipoDePagoApi agregarTipoDePago(TipoDePagoApi request);

	List<TipoDePagoApi> findAll();
}
