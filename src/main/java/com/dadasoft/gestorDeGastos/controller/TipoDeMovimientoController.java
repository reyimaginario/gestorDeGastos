package com.dadasoft.gestorDeGastos.controller;

import com.dadasoft.gestorDeGastos.api.TipoDeMovimientoApi;
import com.dadasoft.gestorDeGastos.service.ITipoDeMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tipodemovimiento")
public class TipoDeMovimientoController {

	@Autowired
	private ITipoDeMovimientoService tipoDeMovimientoService;

	@GetMapping
	public ResponseEntity<List<TipoDeMovimientoApi>> getAll() {
		List<TipoDeMovimientoApi> listTipoDeMovimientoApi;
		listTipoDeMovimientoApi = tipoDeMovimientoService.findAll();
		return new ResponseEntity<>(listTipoDeMovimientoApi, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TipoDeMovimientoApi> agregarTipoDePago(@RequestBody TipoDeMovimientoApi request) {
		TipoDeMovimientoApi tipoDeMovimientoApi;
		tipoDeMovimientoApi = tipoDeMovimientoService.agregarTipoDeMovimiento(request);
		return new ResponseEntity<>(tipoDeMovimientoApi, HttpStatus.CREATED);
	}

}
