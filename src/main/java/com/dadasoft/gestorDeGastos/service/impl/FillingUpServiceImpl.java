package com.dadasoft.gestorDeGastos.service.impl;

import com.dadasoft.gestorDeGastos.entity.CategoriaDAO;
import com.dadasoft.gestorDeGastos.entity.TipoDeMovimientoDAO;
import com.dadasoft.gestorDeGastos.entity.TipoDePagoDAO;
import com.dadasoft.gestorDeGastos.repository.ICategoriaRepo;
import com.dadasoft.gestorDeGastos.repository.ITipoDeMovimientoRepo;
import com.dadasoft.gestorDeGastos.repository.ITipoDePagoRepo;
import com.dadasoft.gestorDeGastos.service.IFillingUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FillingUpServiceImpl implements IFillingUpService {

	@Autowired
	private ICategoriaRepo categoriaRepo;
	@Autowired
	private ITipoDeMovimientoRepo tipoDeMovimientoRepo;
	@Autowired
	private ITipoDePagoRepo tipoDePagoRepo;

	@Override
	public void fillin() {
		fillCategorias();
		fillTipoPagos();
		fillTipoMovimientos();
	}

	private void fillCategorias() {
		CategoriaDAO categoriaDAO;

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setCategoriaDesc("Comida");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setCategoriaDesc("Lavadero");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setCategoriaDesc("Verduleria");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setCategoriaDesc("Supermercado");
		categoriaRepo.save(categoriaDAO);
	}

	private void fillTipoPagos() {
		TipoDePagoDAO tipoDePagoDAO;

		tipoDePagoDAO = new TipoDePagoDAO();
		tipoDePagoDAO.setTipoDePagoDesc("Tarjeta");
		tipoDePagoRepo.save(tipoDePagoDAO);

		tipoDePagoDAO = new TipoDePagoDAO();
		tipoDePagoDAO.setTipoDePagoDesc("MP");
		tipoDePagoRepo.save(tipoDePagoDAO);
	}

	private void fillTipoMovimientos() {
		TipoDeMovimientoDAO tipoDeMovimientoDAO;

		tipoDeMovimientoDAO = new TipoDeMovimientoDAO();
		tipoDeMovimientoDAO.setTipoDeMovimientoDesc("CASHIN");
		tipoDeMovimientoRepo.save(tipoDeMovimientoDAO);

		tipoDeMovimientoDAO = new TipoDeMovimientoDAO();
		tipoDeMovimientoDAO.setTipoDeMovimientoDesc("CASHOUT");
		tipoDeMovimientoRepo.save(tipoDeMovimientoDAO);
	}
}
