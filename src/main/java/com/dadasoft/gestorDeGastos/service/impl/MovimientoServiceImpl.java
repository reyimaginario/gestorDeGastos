package com.dadasoft.gestorDeGastos.service.impl;

import com.dadasoft.gestorDeGastos.api.MovimientoApi;
import com.dadasoft.gestorDeGastos.entity.MovimientoDAO;
import com.dadasoft.gestorDeGastos.entity.catalogo.CategoriaDAO;
import com.dadasoft.gestorDeGastos.entity.catalogo.TipoDeMovimientoDAO;
import com.dadasoft.gestorDeGastos.entity.catalogo.TipoDePagoDAO;
import com.dadasoft.gestorDeGastos.exception.CategoriaException;
import com.dadasoft.gestorDeGastos.exception.TipoDeMovimientoException;
import com.dadasoft.gestorDeGastos.exception.TipoDePagoException;
import com.dadasoft.gestorDeGastos.repository.ICategoriaRepo;
import com.dadasoft.gestorDeGastos.repository.IMovimientoRepo;
import com.dadasoft.gestorDeGastos.repository.ITipoDeMovimientoRepo;
import com.dadasoft.gestorDeGastos.repository.ITipoDePagoRepo;
import com.dadasoft.gestorDeGastos.service.IMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServiceImpl implements IMovimientoService {

	@Autowired
	private IMovimientoRepo movimientoRepo;
	@Autowired
	private ITipoDeMovimientoRepo tipoDeMovimientoRepo;
	@Autowired
	private ICategoriaRepo categoriaRepo;
	@Autowired
	private ITipoDePagoRepo tipoDePagoRepo;

	@Override
	public MovimientoApi agregarMovimiento(MovimientoApi request) throws TipoDeMovimientoException, CategoriaException, TipoDePagoException {
		MovimientoApi movimientoApi;
		MovimientoDAO movimientoDAO;
		movimientoDAO = prepararMovimiento(request);
		movimientoApi = convert(movimientoRepo.save(movimientoDAO));
		return movimientoApi;
	}

	@Override
	public List<MovimientoApi> findAll() {
		List<MovimientoApi> listMovimientoApi;
		listMovimientoApi = convert(movimientoRepo.findAll());
		return listMovimientoApi;
	}



	private MovimientoDAO prepararMovimiento(MovimientoApi api) throws TipoDeMovimientoException, CategoriaException, TipoDePagoException {
		MovimientoDAO dao = new MovimientoDAO();

		LocalDate fecha = Optional.ofNullable(api.getFecha()).orElse(LocalDate.now());
		dao.setFecha(fecha);

		TipoDeMovimientoDAO tipoDeMovimiento = tipoDeMovimientoRepo.findByDesc(api.getTipoDeMovimiento());
		if (tipoDeMovimiento == null)
			throw new TipoDeMovimientoException(TipoDeMovimientoException.TIPO_DE_MOVIMIENTO_NOT_FOUND_CODE,
												TipoDeMovimientoException.TIPO_DE_MOVIMIENTO_NOT_FOUND_MSG + " (" + api.getTipoDeMovimiento() + ")");
		dao.setTipoDeMovimiento(tipoDeMovimiento);

		CategoriaDAO categoria = categoriaRepo.findByDesc(api.getCategoria());
		if (categoria == null)
			throw new CategoriaException(CategoriaException.CATEGORIA_NOT_FOUND_CODE,
					CategoriaException.CATEGORIA_NOT_FOUND_MSG + " (" + api.getCategoria() + ")");
		dao.setCategoria(categoria);

		dao.setMonto(api.getMonto());

		TipoDePagoDAO tipoDePago = null;
		if (api.getTipoDePago() != null && StringUtils.hasText(api.getTipoDePago())) {
			tipoDePago = tipoDePagoRepo.findByDesc(api.getTipoDePago());
			if (tipoDePago == null)
				throw new TipoDePagoException(TipoDePagoException.TIPO_DE_PAGO_NOT_FOUND_CODE,
						TipoDePagoException.TIPO_DE_PAGO_NOT_FOUND_MSG + " (" + api.getTipoDePago() + ")");
		}
		dao.setTipoDePago(tipoDePago);

		dao.setNroCuota(api.getNroCuota());

		dao.setCantCuotas(api.getCantCuotas());

		dao.setComentario(api.getComentario());

		return dao;
	}

	private MovimientoApi convert(MovimientoDAO dao) {
		MovimientoApi api = new MovimientoApi();
		api.setMovimientoId(dao.getMovimientoId());
		api.setFecha(dao.getFecha());
		// TipoDeMovimientoApi tipoDeMovimientoApi = new TipoDeMovimientoApi();
		// tipoDeMovimientoApi.setTipoDeMovimientoId(dao.getTipoDeMovimiento().getId());
		// tipoDeMovimientoApi.setTipoDeMovimientoDesc(dao.getTipoDeMovimiento().getDesc());
		api.setTipoDeMovimiento(dao.getTipoDeMovimiento().getDesc());
		// CategoriaApi categoriaApi = new CategoriaApi();
		// categoriaApi.setCategoriaId(dao.getCategoria().getId());
		// categoriaApi.setCategoriaDesc(dao.getCategoria().getDesc());
		api.setCategoria(dao.getCategoria().getDesc());
		api.setMonto(dao.getMonto());
		// TipoDePagoApi tipoDePagoApi = new TipoDePagoApi();
		if (dao.getTipoDePago() != null) {
			api.setTipoDePago(dao.getTipoDePago().getDesc());
		}
		else {
			api.setTipoDePago(null);
		}
		api.setNroCuota(dao.getNroCuota());
		api.setCantCuotas(dao.getCantCuotas());
		api.setComentario(dao.getComentario());
		return api;
	}

	private List<MovimientoApi> convert(List<MovimientoDAO> listDAO) {
		MovimientoApi api;
		List<MovimientoApi> listApi = new ArrayList<>();
		for (MovimientoDAO dao : listDAO) {
			api = convert(dao);
			listApi.add(api);
		}
		return listApi;
	}
}
