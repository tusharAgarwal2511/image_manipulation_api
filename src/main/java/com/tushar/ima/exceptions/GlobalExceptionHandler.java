package com.tushar.ima.exceptions;

import com.tushar.ima.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(ValueOutOfRangeException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ValueOutOfRangeException ex)
	{
		String      message     = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
}
