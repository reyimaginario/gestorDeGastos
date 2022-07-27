package com.dadasoft.gestorDeGastos.service.impl;

import com.dadasoft.gestorDeGastos.api.catalogo.CategoriaApi;
import com.dadasoft.gestorDeGastos.api.catalogo.TipoDePagoApi;
import com.dadasoft.gestorDeGastos.entity.catalogo.CategoriaDAO;
import com.dadasoft.gestorDeGastos.entity.catalogo.TipoDePagoDAO;
import com.dadasoft.gestorDeGastos.exception.CategoriaException;
import com.dadasoft.gestorDeGastos.exception.TipoDePagoException;
import com.dadasoft.gestorDeGastos.mapper.CatalogoMapper;
import com.dadasoft.gestorDeGastos.repository.ITipoDePagoRepo;
import com.dadasoft.gestorDeGastos.service.ITipoDePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoDePagoServiceImpl implements ITipoDePagoService {

	@Autowired
	public ITipoDePagoRepo tipoPagoRepo;

	@Override
	public List<TipoDePagoApi> obtenerTiposDePagoHabilitados() {
		List<TipoDePagoApi> listTipoDePagoApi;
		listTipoDePagoApi = convert(tipoPagoRepo.findByEnableTrue());
		return listTipoDePagoApi;
	}

	@Override
	public List<TipoDePagoApi> findAll() {
		List<TipoDePagoApi> listTipoDePagoApi;
		listTipoDePagoApi = convert(tipoPagoRepo.findAll());
		return listTipoDePagoApi;
	}

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
	public TipoDePagoApi deshabilitarTipoDePago(String id) throws TipoDePagoException {
		TipoDePagoApi tipoDePagoApi;
		TipoDePagoDAO tipoDePagoDAO = buscarTipoDePago(id);
		tipoDePagoDAO.setEnable(false);
		tipoDePagoApi = convert(tipoPagoRepo.saveAndFlush(tipoDePagoDAO));
		return tipoDePagoApi;

	}

	@Override
	public TipoDePagoApi updateTipoDePago(TipoDePagoApi request) throws TipoDePagoException {
		TipoDePagoApi tipoDePagoApi;
		TipoDePagoDAO tipoDePagoDAO = buscarTipoDePago(request.getId());
		tipoDePagoDAO.setDesc(request.getDesc());
		tipoDePagoApi = convert(tipoPagoRepo.saveAndFlush(tipoDePagoDAO));
		return tipoDePagoApi;
	}


	private TipoDePagoDAO buscarTipoDePago(String id) throws TipoDePagoException {
		return buscarTipoDePago(Long.parseLong(id));
	}

	private TipoDePagoDAO buscarTipoDePago(long id) throws TipoDePagoException {
		Optional<TipoDePagoDAO> opTipoDePagoDAO = tipoPagoRepo.findById(id);
		TipoDePagoDAO tipoDePagoDAO = opTipoDePagoDAO.orElseThrow(() -> new TipoDePagoException(TipoDePagoException.TIPO_DE_PAGO_NOT_FOUND_CODE,
				TipoDePagoException.TIPO_DE_PAGO_NOT_FOUND_MSG + " (" + id + ")"));
		return tipoDePagoDAO;
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
