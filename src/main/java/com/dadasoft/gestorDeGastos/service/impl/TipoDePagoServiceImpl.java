package com.dadasoft.gestorDeGastos.service.impl;

import com.dadasoft.gestorDeGastos.api.TipoDePagoApi;
import com.dadasoft.gestorDeGastos.entity.TipoDePagoDAO;
import com.dadasoft.gestorDeGastos.repository.ITipoDePagoRepo;
import com.dadasoft.gestorDeGastos.service.ITipoDePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoDePagoServiceImpl implements ITipoDePagoService {

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
}
