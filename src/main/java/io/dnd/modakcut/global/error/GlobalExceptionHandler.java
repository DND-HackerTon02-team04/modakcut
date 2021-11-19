package io.dnd.modakcut.global.error;

import io.dnd.modakcut.global.error.exception.ErrorCode;
import io.dnd.modakcut.global.error.exception.ModakcutException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	protected ResponseEntity<ErrorResponse> ModakcutHandling(ModakcutException e) {
		ErrorCode code = e.getErrorCode();
		return new ResponseEntity<>(new ErrorResponse(code.getStatus(), code.getMessage()),
				HttpStatus.valueOf(code.getStatus()));
	}

}
