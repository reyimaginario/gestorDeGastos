package com.dadasoft.gestorDeGastos.controller;

import com.dadasoft.gestorDeGastos.api.catalogo.CategoriaApi;
import com.dadasoft.gestorDeGastos.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<List<CategoriaApi>> obtenerCategoriasHabilitadas() {
		List<CategoriaApi> listCategoriesApi;
		listCategoriesApi = categoriaService.obtenerCategoriasHabilitadas();
		return new ResponseEntity<>(listCategoriesApi, HttpStatus.OK);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<List<CategoriaApi>> getAll() {
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

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<CategoriaApi> deshabilitarCategoria(@PathVariable("id") String id) throws Exception {
		CategoriaApi categoriaApi;
		categoriaApi = categoriaService.deshabilitarCategoria(id);
		return new ResponseEntity<>(categoriaApi, HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<CategoriaApi> updateCategoria(@RequestBody CategoriaApi request) throws Exception {
		CategoriaApi categoriaApi;
		categoriaApi = categoriaService.actualizarCategoria(request);
		return new ResponseEntity<>(categoriaApi, HttpStatus.OK);
	}
}
