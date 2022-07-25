package com.dadasoft.gestorDeGastos.entity.catalogo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <h2>TipoDeMovimientoDAO</h2>
 *
 * <p>Clase destinada a mapear tipos de movimientos</p>
 * <p>
 *     <ul>
 *         <li>CASHIN: Ingresos</li>
 *         <li>CASHOUT: Egresos</li>
 *     </ul>
 * </p>
 */

@Getter
@Setter
@Entity
@Table(name = "tipo_movimiento")
public class TipoDeMovimientoDAO extends CatalogoDAO {

}
