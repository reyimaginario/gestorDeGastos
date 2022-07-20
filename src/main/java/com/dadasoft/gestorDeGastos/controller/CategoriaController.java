package com.dadasoft.gestorDeGastos.controller;

import com.dadasoft.gestorDeGastos.api.CategoriaApi;
import com.dadasoft.gestorDeGastos.service.ICategoriaService;
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
@RequestMapping(value = "/categoria")
public class CategoriaController {

	@Autowired
	private ICategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<CategoriaApi>> getAllCategories() {
		List<CategoriaApi> listCategoriesApi;
		listCategoriesApi = categoriaService.findAll();
		return new ResponseEntity<>(listCategoriesApi, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CategoriaApi> agregarCategoria(@RequestBody CategoriaApi request) {
		CategoriaApi categoriaApi;
		categoriaApi = categoriaService.agregarCategoria(request);
		return new ResponseEntity<>(categoriaApi, HttpStatus.CREATED);
	}
}
