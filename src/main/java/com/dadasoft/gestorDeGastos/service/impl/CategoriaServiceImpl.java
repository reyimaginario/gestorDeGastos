package com.dadasoft.gestorDeGastos.service.impl;

import com.dadasoft.gestorDeGastos.api.catalogo.CategoriaApi;
import com.dadasoft.gestorDeGastos.entity.catalogo.CategoriaDAO;
import com.dadasoft.gestorDeGastos.exception.CategoriaException;
import com.dadasoft.gestorDeGastos.mapper.CatalogoMapper;
import com.dadasoft.gestorDeGastos.repository.ICategoriaRepo;
import com.dadasoft.gestorDeGastos.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	public List<CategoriaApi> findAll() {
		List<CategoriaApi> listCategoriesApi;
		listCategoriesApi = convert(categoriaRepo.findAll());
		return listCategoriesApi;
	}

	@Override
	public CategoriaApi agregarCategoria(CategoriaApi request) {
		CategoriaApi categoriaApi;
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc(request.getDesc());
		categoriaDAO.setEnable(true);
		categoriaApi = convert(categoriaRepo.save(categoriaDAO));
		return categoriaApi;
	}

	@Override
	public CategoriaApi deshabilitarCategoria(String id) throws CategoriaException {
		CategoriaApi categoriaApi;
		CategoriaDAO categoriaDAO = buscarCategoria(id);
		categoriaDAO.setEnable(false);
		categoriaApi = convert(categoriaRepo.saveAndFlush(categoriaDAO));
		return categoriaApi;
	}

	@Override
	public CategoriaApi actualizarCategoria(CategoriaApi request) throws CategoriaException {
		CategoriaApi categoriaApi;
		CategoriaDAO categoriaDAO = buscarCategoria(request.getId());
		categoriaDAO.setDesc(request.getDesc());
		categoriaApi = convert(categoriaRepo.saveAndFlush(categoriaDAO));
		return categoriaApi;
	}


	private CategoriaDAO buscarCategoria(String id) throws CategoriaException {
		return buscarCategoria(Long.parseLong(id));
	}

	private CategoriaDAO buscarCategoria(Long id) throws CategoriaException {
		Optional<CategoriaDAO> opCategoriaDAO = categoriaRepo.findById(id);
		CategoriaDAO categoriaDAO = opCategoriaDAO.orElseThrow(() -> new CategoriaException(CategoriaException.CATEGORIA_NOT_FOUND_CODE,
				CategoriaException.CATEGORIA_NOT_FOUND_MSG + " (" + id + ")"));
		return categoriaDAO;
	}

	private CategoriaApi convert(CategoriaDAO dao) {
		CategoriaApi api = new CategoriaApi();
		CatalogoMapper<CategoriaApi, CategoriaDAO> mapper = new CatalogoMapper<>(api, dao);
		return mapper.convertDaoToApi();
	}

	private List<CategoriaApi> convert(List<CategoriaDAO> listDAO) {
		List<CategoriaApi> listApi = listDAO.stream()
											.map(dao -> convert(dao))
											.collect(Collectors.toList());

		return listApi;
	}
}
