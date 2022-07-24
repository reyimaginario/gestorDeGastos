package com.dadasoft.gestorDeGastos.exception.handler;

import com.dadasoft.gestorDeGastos.api.ErrorApi;
import com.dadasoft.gestorDeGastos.exception.CategoriaException;
import com.dadasoft.gestorDeGastos.exception.TipoDeMovimientoException;
import com.dadasoft.gestorDeGastos.exception.TipoDePagoException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private ResponseEntity<Object> buildResponseEntity(ErrorApi errApi) {
		return new ResponseEntity<>(errApi, errApi.getStatus());
	}

	@ExceptionHandler(TipoDeMovimientoException.class)
	protected ResponseEntity<Object> handleTipoDeMovimientoError(TipoDeMovimientoException ex) {
		return buildResponseEntity(new ErrorApi(HttpStatus.NOT_FOUND, ex.getErrorCode(), ex.getMessage()));
	}

	@ExceptionHandler(CategoriaException.class)
	protected ResponseEntity<Object> handleCategoriaError(CategoriaException ex) {
		return buildResponseEntity(new ErrorApi(HttpStatus.NOT_FOUND, ex.getErrorCode(), ex.getMessage()));
	}

	@ExceptionHandler(TipoDePagoException.class)
	protected ResponseEntity<Object> handleTipoDePagoError(TipoDePagoException ex) {
		return buildResponseEntity(new ErrorApi(HttpStatus.NOT_FOUND, ex.getErrorCode(), ex.getMessage()));
	}
}
