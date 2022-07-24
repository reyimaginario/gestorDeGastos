package com.dadasoft.gestorDeGastos.exception;

public class CategoriaException extends GenericException {

	private static final long serialVersionUID = -643969408997742204L;

	public static final String CATEGORIA_NOT_FOUND_CODE = "102";
	public static final String CATEGORIA_NOT_FOUND_MSG = "Categoria no encontrada";

	public CategoriaException(String errCode, String msg) {
		super(errCode, msg);
	}

	public CategoriaException(String errCode, String msg, Throwable ex) {
		super(errCode, msg, ex);
	}
}
