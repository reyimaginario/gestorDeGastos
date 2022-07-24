package com.dadasoft.gestorDeGastos.exception;

public class TipoDePagoException extends GenericException {

	private static final long serialVersionUID = 5624256839159557228L;

	public static final String TIPO_DE_PAGO_NOT_FOUND_CODE = "103";
	public static final String TIPO_DE_PAGO_NOT_FOUND_MSG = "Tipo de pago no encontrado";

	public TipoDePagoException(String errCode, String msg) {
		super(errCode, msg);
	}

	public TipoDePagoException(String errCode, String msg, Throwable ex) {
		super(errCode, msg, ex);
	}
}
