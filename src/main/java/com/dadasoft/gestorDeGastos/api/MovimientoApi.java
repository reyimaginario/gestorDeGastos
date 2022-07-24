package com.dadasoft.gestorDeGastos.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovimientoApi {

	private Long movimientoId;
	private LocalDate fecha;
	private String tipoDeMovimiento;
	private String categoria;
	private Float monto;
	private String tipoDePago;
	private Integer nroCuota;
	private Integer cantCuotas;
	private String comentario;
}
