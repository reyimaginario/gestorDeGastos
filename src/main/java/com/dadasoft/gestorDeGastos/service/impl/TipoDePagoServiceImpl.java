package com.dadasoft.gestorDeGastos.service.impl;

import com.dadasoft.gestorDeGastos.api.catalogo.CategoriaApi;
import com.dadasoft.gestorDeGastos.api.catalogo.TipoDePagoApi;
import com.dadasoft.gestorDeGastos.entity.catalogo.CategoriaDAO;
import com.dadasoft.gestorDeGastos.entity.catalogo.TipoDePagoDAO;
import com.dadasoft.gestorDeGastos.mapper.CatalogoMapper;
import com.dadasoft.gestorDeGastos.repository.ITipoDePagoRepo;
import com.dadasoft.gestorDeGastos.service.ITipoDePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoDePagoServiceImpl implements ITipoDePagoService {

	@Autowired
	public ITipoDePagoRepo tipoPagoRepo;

	@Override
	public TipoDePagoApi agregarTipoDePago(TipoDePagoApi request) {
		TipoDePagoApi tipoDePagoApi;
		TipoDePagoDAO tipoDePagoDAO = new TipoDePagoDAO();
		tipoDePagoDAO.setDesc(request.getDesc());
		tipoDePagoDAO.setEnable(true);
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
		CatalogoMapper<TipoDePagoApi, TipoDePagoDAO> mapper = new CatalogoMapper<>(api, dao);
		return mapper.convertDaoToApi();
	}
	private List<TipoDePagoApi> convert(List<TipoDePagoDAO> listDAO) {
		List<TipoDePagoApi> listApi = listDAO.stream()
				.map(dao -> convert(dao))
				.collect(Collectors.toList());

		return listApi;
	}
}
