package com.aduilio.designpatterns.exception;

public class InvalidCepException extends RuntimeException {

	private static final long serialVersionUID = -3040774465392193904L;

	public InvalidCepException(final String cep) {
		super(String.format("CEP %s is invalid.", cep));
	}
}
