package com.dadasoft.gestorDeGastos.controller;

import com.dadasoft.gestorDeGastos.service.IFillingUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fillingup")
public class InicializadorController {

	@Autowired
	private IFillingUpService fillingUpService;

	@GetMapping
	public ResponseEntity<String> fillingup() {
		fillingUpService.fillin();
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}
}
