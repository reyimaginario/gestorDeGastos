package com.dadasoft.gestorDeGastos.exception;

import java.util.function.Supplier;

public class TipoDeMovimientoException extends GenericException {

	private static final long serialVersionUID = 5945437242303043685L;

	public static final String TIPO_DE_MOVIMIENTO_NOT_FOUND_CODE = "101";
	public static final String TIPO_DE_MOVIMIENTO_NOT_FOUND_MSG = "Tipo de movimiento no encontrado";

	public TipoDeMovimientoException(String errCode, String msg) {
		super(msg, errCode);
	}

	public TipoDeMovimientoException(String errCode, String msg, Throwable ex) {
		super(msg, errCode, ex);
	}

}
