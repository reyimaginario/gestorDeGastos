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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipoPago")
public class TipoDePagoDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tipoDePagoId;

	private String tipoDePagoDesc;
}
