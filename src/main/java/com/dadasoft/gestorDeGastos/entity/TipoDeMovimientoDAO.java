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
@Table(name = "tipo_movimiento")
public class TipoDeMovimientoDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tipoDeMovimientoId;

	private String tipoDeMovimientoDesc;
}
