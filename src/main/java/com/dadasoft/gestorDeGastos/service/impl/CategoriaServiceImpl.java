package com.dadasoft.gestorDeGastos.service.impl;

import com.dadasoft.gestorDeGastos.api.CategoriaApi;
import com.dadasoft.gestorDeGastos.entity.CategoriaDAO;
import com.dadasoft.gestorDeGastos.repository.ICategoriaRepo;
import com.dadasoft.gestorDeGastos.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private ICategoriaRepo categoriaRepo;


	@Override
	public List<CategoriaApi> obtenerCategoriasHabilitadas() {
		List<CategoriaApi> listCategoriesApi;
		listCategoriesApi = convert(categoriaRepo.findByEnableTrue());
		return listCategoriesApi;
	}

	@Override
	public CategoriaApi agregarCategoria(CategoriaApi request) {
		CategoriaApi categoriaApi;
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc(request.getCategoriaDesc());
		categoriaDAO.setEnable(true);
		categoriaApi = convert(categoriaRepo.save(categoriaDAO));
		return categoriaApi;
	}

	@Override
	public List<CategoriaApi> findAll() {
		List<CategoriaApi> listCategoriesApi;
		listCategoriesApi = convert(categoriaRepo.findAll());
		return listCategoriesApi;
	}


	private CategoriaApi convert(CategoriaDAO dao) {
		CategoriaApi api = new CategoriaApi();
		api.setCategoriaId(dao.getId());
		api.setCategoriaDesc(dao.getDesc());
		return api;
	}

	private List<CategoriaApi> convert(List<CategoriaDAO> listDAO) {
		CategoriaApi api;
		List<CategoriaApi> listApi = new ArrayList<>();
		for (CategoriaDAO dao : listDAO) {
			api = convert(dao);
			listApi.add(api);
		}
		return listApi;
	}
}
