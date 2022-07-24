package com.dadasoft.gestorDeGastos.entity.catalogo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * <h2>Catalogo</h2>
 *
 * <p>Clase destinada a ser la referencia de todas las demas clases de tipo catalogo (tipo enums)</p>
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Catalogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descripcion", nullable = false)
	private String desc;

	@Column(name = "habilitado", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean enable = true;
}
