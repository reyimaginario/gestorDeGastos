package com.dadasoft.gestorDeGastos.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorApi {

	@JsonProperty
	private LocalDateTime timeStamp;
	@JsonProperty
	private HttpStatus status;
	@JsonProperty
	private String errorCode;
	@JsonProperty
	private String message;

	public ErrorApi() {
		this.timeStamp = LocalDateTime.now();
	}

	public ErrorApi(HttpStatus status, String errCode, String msg) {
		this.timeStamp = LocalDateTime.now();
		this.status = status;
		this.errorCode = errCode;
		this.message = msg;
	}
}
