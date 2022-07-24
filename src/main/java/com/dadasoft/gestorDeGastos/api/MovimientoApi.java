package com.dadasoft.gestorDeGastos.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoApi {

	private Long movimientoId;
	private LocalDate fecha;
	private TipoDeMovimientoApi tipoDeMovimiento;
	private CategoriaApi categoria;
	private Float monto;
	private TipoDePagoApi tipoDePago;
	private Integer nroCuota;
	private Integer cantCuotas;
	private String comentario;
}
