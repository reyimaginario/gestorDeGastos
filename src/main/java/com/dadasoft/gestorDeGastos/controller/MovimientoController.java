package com.dadasoft.gestorDeGastos.controller;

import com.dadasoft.gestorDeGastos.api.MovimientoApi;
import com.dadasoft.gestorDeGastos.service.IMovimientoService;
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
@RequestMapping(value = "/movimiento")
public class MovimientoController {

	@Autowired
	private IMovimientoService movimientoService;

	@PostMapping
	public ResponseEntity<MovimientoApi> agregarMovimiento(@RequestBody MovimientoApi request) throws Exception {
		MovimientoApi movimientoApi;
		movimientoApi = movimientoService.agregarMovimiento(request);
		return new ResponseEntity<>(movimientoApi, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<MovimientoApi>> getAll() {
		List<MovimientoApi> listMovimientosApi;
		listMovimientosApi = movimientoService.findAll();
		return new ResponseEntity<>(listMovimientosApi, HttpStatus.OK);
	}
}
