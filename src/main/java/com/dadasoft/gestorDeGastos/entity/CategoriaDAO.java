package com.dadasoft.gestorDeGastos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoria")
public class CategoriaDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoriaId;

	private String categoriaDesc;
}
