package com.dadasoft.gestorDeGastos.service.impl;

import com.dadasoft.gestorDeGastos.api.CategoriaApi;
import com.dadasoft.gestorDeGastos.api.MovimientoApi;
import com.dadasoft.gestorDeGastos.api.TipoDeMovimientoApi;
import com.dadasoft.gestorDeGastos.api.TipoDePagoApi;
import com.dadasoft.gestorDeGastos.entity.CategoriaDAO;
import com.dadasoft.gestorDeGastos.entity.MovimientoDAO;
import com.dadasoft.gestorDeGastos.entity.TipoDeMovimientoDAO;
import com.dadasoft.gestorDeGastos.entity.TipoDePagoDAO;
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

		TipoDeMovimientoDAO tipoDeMovimiento = tipoDeMovimientoRepo.findByTipoDeMovimientoDesc(api.getTipoDeMovimiento().getTipoDeMovimientoDesc());
		if (tipoDeMovimiento == null)
			throw new TipoDeMovimientoException(TipoDeMovimientoException.TIPO_DE_MOVIMIENTO_NOT_FOUND_CODE,
												TipoDeMovimientoException.TIPO_DE_MOVIMIENTO_NOT_FOUND_MSG + " (" + api.getTipoDeMovimiento().getTipoDeMovimientoDesc() + ")");
		dao.setTipoDeMovimiento(tipoDeMovimiento);

		CategoriaDAO categoria = categoriaRepo.findByCategoriaDesc(api.getCategoria().getCategoriaDesc());
		if (categoria == null)
			throw new CategoriaException(CategoriaException.CATEGORIA_NOT_FOUND_CODE,
					CategoriaException.CATEGORIA_NOT_FOUND_MSG + " (" + api.getCategoria().getCategoriaDesc() + ")");
		dao.setCategoria(categoria);

		dao.setMonto(api.getMonto());

		TipoDePagoDAO tipoDePago = null;
		if (api.getTipoDePago() != null && StringUtils.hasText(api.getTipoDePago().getTipoDePagoDesc())) {
			tipoDePago = tipoDePagoRepo.findByTipoDePagoDesc(api.getTipoDePago().getTipoDePagoDesc());
			if (tipoDePago == null)
				throw new TipoDePagoException(TipoDePagoException.TIPO_DE_PAGO_NOT_FOUND_CODE,
						TipoDePagoException.TIPO_DE_PAGO_NOT_FOUND_MSG + " (" + api.getTipoDePago().getTipoDePagoDesc() + ")");
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
		TipoDeMovimientoApi tipoDeMovimientoApi = new TipoDeMovimientoApi();
		tipoDeMovimientoApi.setTipoDeMovimientoId(dao.getTipoDeMovimiento().getTipoDeMovimientoId());
		tipoDeMovimientoApi.setTipoDeMovimientoDesc(dao.getTipoDeMovimiento().getTipoDeMovimientoDesc());
		api.setTipoDeMovimiento(tipoDeMovimientoApi);
		CategoriaApi categoriaApi = new CategoriaApi();
		categoriaApi.setCategoriaId(dao.getCategoria().getCategoriaId());
		categoriaApi.setCategoriaDesc(dao.getCategoria().getCategoriaDesc());
		api.setCategoria(categoriaApi);
		api.setMonto(dao.getMonto());
		TipoDePagoApi tipoDePagoApi = new TipoDePagoApi();
		if (dao.getTipoDePago() != null) {
			tipoDePagoApi.setTipoDePagoId(dao.getTipoDePago().getTipoDePagoId());
			tipoDePagoApi.setTipoDePagoDesc(dao.getTipoDePago().getTipoDePagoDesc());
		}
		api.setTipoDePago(tipoDePagoApi);
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
