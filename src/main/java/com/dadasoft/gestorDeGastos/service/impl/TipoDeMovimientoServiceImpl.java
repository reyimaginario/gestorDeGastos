package com.dadasoft.gestorDeGastos.service.impl;

import com.dadasoft.gestorDeGastos.api.TipoDeMovimientoApi;
import com.dadasoft.gestorDeGastos.entity.catalogo.TipoDeMovimientoDAO;
import com.dadasoft.gestorDeGastos.repository.ITipoDeMovimientoRepo;
import com.dadasoft.gestorDeGastos.service.ITipoDeMovimientoService;
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
		tipoDeMovimientoDAO.setDesc(request.getTipoDeMovimientoDesc());
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
		api.setTipoDeMovimientoId(dao.getId());
		api.setTipoDeMovimientoDesc(dao.getDesc());
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
}
