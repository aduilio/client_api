package com.aduilio.designpatterns.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = InvalidCepException.class)
	public ResponseEntity<Object> resourceNotFoundException(final InvalidCepException ex, final WebRequest request) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
}
