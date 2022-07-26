package com.dadasoft.gestorDeGastos.mapper;

import com.dadasoft.gestorDeGastos.api.catalogo.CatalogoApi;
import com.dadasoft.gestorDeGastos.entity.catalogo.CatalogoDAO;

public class CatalogoMapper<API extends CatalogoApi, DAO extends CatalogoDAO> {

	private API api;
	private DAO dao;

	public CatalogoMapper(API api, DAO dao) {
		this.api = api;
		this.dao = dao;
	}

	public API convertDaoToApi() {
		api.setId(dao.getId());
		api.setDesc(dao.getDesc());
		return api;
	}

}
