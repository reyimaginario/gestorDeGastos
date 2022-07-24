package com.dadasoft.gestorDeGastos.entity.catalogo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <h2>CategoriaDAO</h2>
 *
 * <p>Clase destinada a mapear la categoria de los movimientos</p>
 * <p>
 *     <ul>
 *         <li>Supermercado</li>
 *         <li>Comida</li>
 *         <li>Varios</li>
 *         <li>etc...</li>
 *     </ul>
 * </p>
 */

@Getter
@Setter
@Entity
@Table(name = "categoria")
public class CategoriaDAO extends Catalogo {

}
