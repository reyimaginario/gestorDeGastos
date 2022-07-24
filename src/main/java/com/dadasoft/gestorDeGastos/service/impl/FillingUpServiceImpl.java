package com.dadasoft.gestorDeGastos.service.impl;

import com.dadasoft.gestorDeGastos.entity.MovimientoDAO;
import com.dadasoft.gestorDeGastos.entity.catalogo.CategoriaDAO;
import com.dadasoft.gestorDeGastos.entity.catalogo.TipoDeMovimientoDAO;
import com.dadasoft.gestorDeGastos.entity.catalogo.TipoDePagoDAO;
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
		categoriaDAO.setDesc("Celular");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Zurich");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Regalo");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Imp_Tarj");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Alquiler");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Expensas");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Tuenti");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("UP");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Fibertel");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Edesur");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("AySA");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Metrogas");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Lavadero");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Supermercado");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Limpieza");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Salida");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("SUBE");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Comida");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Varios");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Taxi");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("MercadoLibre");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Peluquería");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Ropa");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Farmacia");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Vacaciones");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Curso");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Fiesta");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Verdulería");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Kiosco");
		categoriaRepo.save(categoriaDAO);

		categoriaDAO = new CategoriaDAO();
		categoriaDAO.setDesc("Swing");
		categoriaRepo.save(categoriaDAO);
	}

	private void fillTipoPagos() {
		TipoDePagoDAO tipoDePagoDAO;

		tipoDePagoDAO = new TipoDePagoDAO();
		tipoDePagoDAO.setDesc("Tarjeta");
		tipoDePagoRepo.save(tipoDePagoDAO);

		tipoDePagoDAO = new TipoDePagoDAO();
		tipoDePagoDAO.setDesc("MP");
		tipoDePagoRepo.save(tipoDePagoDAO);

		tipoDePagoDAO = new TipoDePagoDAO();
		tipoDePagoDAO.setDesc("MPA");
		tipoDePagoRepo.save(tipoDePagoDAO);
	}

	private void fillTipoMovimientos() {
		TipoDeMovimientoDAO tipoDeMovimientoDAO;

		tipoDeMovimientoDAO = new TipoDeMovimientoDAO();
		tipoDeMovimientoDAO.setDesc("CASHIN");
		tipoDeMovimientoRepo.save(tipoDeMovimientoDAO);

		tipoDeMovimientoDAO = new TipoDeMovimientoDAO();
		tipoDeMovimientoDAO.setDesc("CASHOUT");
		tipoDeMovimientoRepo.save(tipoDeMovimientoDAO);
	}

}
