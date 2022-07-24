package com.dadasoft.gestorDeGastos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movimiento")
public class MovimientoDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movimientoId;

	@Column(name = "fecha", nullable = false, columnDefinition = "DATE")
	private LocalDate fecha;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "tipoDeMovimientoId", foreignKey = @ForeignKey(name = "FK_MOVIMIENTO_TIPOMOVIMIENTO"))
	private TipoDeMovimientoDAO tipoDeMovimiento;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "categoriaId", foreignKey = @ForeignKey(name = "FK_MOVIMIENTO_CATEGORIA"))
	private CategoriaDAO categoria;

	@Column(name = "monto", nullable = false, columnDefinition = "FLOAT")
	private Float monto;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "tipoDePagoId", foreignKey = @ForeignKey(name = "FK_MOVIMIENTO_TIPOPAGO"))
	private TipoDePagoDAO tipoDePago;

	@Column(name = "nroCuota", columnDefinition = "INT")
	private Integer nroCuota;

	@Column(name = "cantCuotas", columnDefinition = "INT")
	private Integer cantCuotas;

	@Column(name = "comentario", columnDefinition = "VARCHAR(255)")
	private String comentario;

}
