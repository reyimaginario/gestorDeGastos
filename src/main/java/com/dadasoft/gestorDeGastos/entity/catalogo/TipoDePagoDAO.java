package com.dadasoft.gestorDeGastos.entity.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <h2>TipoDePagoDAO</h2>
 *
 * <p>Clase destinada a mapear tipos de pagos</p>
 * <p>
 *     <ul>
 *         <li>Tarjeta</li>
 *         <li>Efectivo</li>
 *         <li>etc...</li>
 *     </ul>
 * </p>
 */

@Getter
@Setter
@Entity
@Table(name = "tipo_pago")
public class TipoDePagoDAO extends Catalogo {

}
