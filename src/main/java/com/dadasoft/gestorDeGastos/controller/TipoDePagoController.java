package com.dadasoft.gestorDeGastos.controller;

import com.dadasoft.gestorDeGastos.api.catalogo.TipoDePagoApi;
import com.dadasoft.gestorDeGastos.service.ITipoDePagoService;
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
@RequestMapping(value = "/tipodepago")
public class TipoDePagoController {

	@Autowired
	private ITipoDePagoService tipoDePagoService;

	@GetMapping
	public ResponseEntity<List<TipoDePagoApi>> getAll() {
		List<TipoDePagoApi> listTipoDePagoApi;
		listTipoDePagoApi = tipoDePagoService.findAll();
		return new ResponseEntity<>(listTipoDePagoApi, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TipoDePagoApi> agregarTipoDePago(@RequestBody TipoDePagoApi request) {
		TipoDePagoApi tipoDePagoApi;
		tipoDePagoApi = tipoDePagoService.agregarTipoDePago(request);
		return new ResponseEntity<>(tipoDePagoApi, HttpStatus.CREATED);
	}

}
