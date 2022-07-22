package com.dadasoft.gestorDeGastos.service.impl;

import com.dadasoft.gestorDeGastos.api.TipoDeMovimientoApi;
import com.dadasoft.gestorDeGastos.api.TipoDePagoApi;
import com.dadasoft.gestorDeGastos.entity.TipoDeMovimientoDAO;
import com.dadasoft.gestorDeGastos.entity.TipoDePagoDAO;
import com.dadasoft.gestorDeGastos.repository.ITipoDeMovimientoRepo;
import com.dadasoft.gestorDeGastos.repository.ITipoDePagoRepo;
import com.dadasoft.gestorDeGastos.service.ITipoDeMovimientoService;
import com.dadasoft.gestorDeGastos.service.ITipoDePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoDeMovimientoServiceImpl implements ITipoDeMovimientoService {

	@Autowired
	private ITipoDeMovimientoRepo tipoDeMovimientoRepo;

	@Override
	public TipoDeMovimientoApi agregarTipoDeMovimiento(TipoDeMovimientoApi request) {
		TipoDeMovimientoApi tipoDeMovimientoApi;
		TipoDeMovimientoDAO tipoDeMovimientoDAO = new TipoDeMovimientoDAO();
		tipoDeMovimientoDAO.setTipoDeMovimientoDesc(request.getTipoDeMovimientoDesc());
		tipoDeMovimientoApi = convert(tipoDeMovimientoRepo.save(tipoDeMovimientoDAO));
		return tipoDeMovimientoApi;
	}

	@Override
	public List<TipoDeMovimientoApi> findAll() {
		List<TipoDeMovimientoApi> listTipoDeMovimientoApi;
		listTipoDeMovimientoApi = convert(tipoDeMovimientoRepo.findAll());
		return listTipoDeMovimientoApi;
	}

	private TipoDeMovimientoApi convert(TipoDeMovimientoDAO dao) {
		TipoDeMovimientoApi api = new TipoDeMovimientoApi();
		api.setTipoDeMovimientoId(dao.getTipoDeMovimientoId());
		api.setTipoDeMovimientoDesc(dao.getTipoDeMovimientoDesc());
		return api;
	}

	private List<TipoDeMovimientoApi> convert(List<TipoDeMovimientoDAO> listDAO) {
		TipoDeMovimientoApi api;
		List<TipoDeMovimientoApi> listApi = new ArrayList<>();
		for (TipoDeMovimientoDAO dao : listDAO) {
			api = convert(dao);
			listApi.add(api);
		}
		return listApi;
	}

	/*
	@Autowired
	public ITipoDePagoRepo tipoPagoRepo;

	@Override
	public TipoDePagoApi agregarTipoDePago(TipoDePagoApi request) {
		TipoDePagoApi tipoDePagoApi;
		TipoDePagoDAO tipoDePagoDAO = new TipoDePagoDAO();
		tipoDePagoDAO.setTipoDePagoDesc(request.getTipoDePagoDesc());
		tipoDePagoApi = convert(tipoPagoRepo.save(tipoDePagoDAO));
		return tipoDePagoApi;
	}

	@Override
	public List<TipoDePagoApi> findAll() {
		List<TipoDePagoApi> listTipoDePagoApi;
		listTipoDePagoApi = convert(tipoPagoRepo.findAll());
		return listTipoDePagoApi;
	}


	private TipoDePagoApi convert(TipoDePagoDAO dao) {
		TipoDePagoApi api = new TipoDePagoApi();
		api.setTipoDePagoId(dao.getTipoDePagoId());
		api.setTipoDePagoDesc(dao.getTipoDePagoDesc());
		return api;
	}
	private List<TipoDePagoApi> convert(List<TipoDePagoDAO> listDAO) {
		TipoDePagoApi api;
		List<TipoDePagoApi> listApi = new ArrayList<>();
		for (TipoDePagoDAO dao : listDAO) {
			api = convert(dao);
			listApi.add(api);
		}
		return listApi;
	}

	 */
}
