package com.dadasoft.gestorDeGastos.service.impl;

import com.dadasoft.gestorDeGastos.api.catalogo.CategoriaApi;
import com.dadasoft.gestorDeGastos.api.catalogo.TipoDeMovimientoApi;
import com.dadasoft.gestorDeGastos.entity.catalogo.CategoriaDAO;
import com.dadasoft.gestorDeGastos.entity.catalogo.TipoDeMovimientoDAO;
import com.dadasoft.gestorDeGastos.mapper.CatalogoMapper;
import com.dadasoft.gestorDeGastos.repository.ITipoDeMovimientoRepo;
import com.dadasoft.gestorDeGastos.service.ITipoDeMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoDeMovimientoServiceImpl implements ITipoDeMovimientoService {

	@Autowired
	private ITipoDeMovimientoRepo tipoDeMovimientoRepo;

	@Override
	public TipoDeMovimientoApi agregarTipoDeMovimiento(TipoDeMovimientoApi request) {
		TipoDeMovimientoApi tipoDeMovimientoApi;
		TipoDeMovimientoDAO tipoDeMovimientoDAO = new TipoDeMovimientoDAO();
		tipoDeMovimientoDAO.setDesc(request.getDesc());
		tipoDeMovimientoDAO.setEnable(true);
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
		CatalogoMapper<TipoDeMovimientoApi, TipoDeMovimientoDAO> mapper = new CatalogoMapper<>(api, dao);
		return mapper.convertDaoToApi();
	}

	private List<TipoDeMovimientoApi> convert(List<TipoDeMovimientoDAO> listDAO) {
		List<TipoDeMovimientoApi> listApi = listDAO.stream()
				.map(dao -> convert(dao))
				.collect(Collectors.toList());

		return listApi;
	}
}
