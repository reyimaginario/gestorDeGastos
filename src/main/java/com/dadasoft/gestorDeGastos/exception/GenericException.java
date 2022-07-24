package com.dadasoft.gestorDeGastos.exception;

public class GenericException extends Exception {

	private static final long serialVersionUID = -2878622473598238526L;

	private final String errorCode;

	public GenericException(String errCode, String msg) {
		super(msg);
		this.errorCode = errCode;
	}

	public GenericException(String errCode, String msg, Throwable ex) {
		super(msg, ex);
		this.errorCode = errCode;
	}

	public String getErrorCode() {
		return this.errorCode;
	}
}
