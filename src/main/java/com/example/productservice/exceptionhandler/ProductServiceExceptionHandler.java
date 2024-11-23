package com.example.productservice.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.productservice.dto.ProductNotFoundExceptionDto;
import com.example.productservice.exception.ProductNotfoundException;


@ControllerAdvice
public class ProductServiceExceptionHandler
{
	@ExceptionHandler(ProductNotfoundException.class)
	public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotfoundException e){
		ProductNotFoundExceptionDto errorResponse = new ProductNotFoundExceptionDto();
		errorResponse.setErrorCode(e.getId());
		errorResponse.setMessage(e.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	//handle null pointer exception
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ProductNotFoundExceptionDto> handleNullPointerException(NullPointerException e){
		ProductNotFoundExceptionDto errorResponse = new ProductNotFoundExceptionDto();
		errorResponse.setErrorCode(0L);
		errorResponse.setMessage("Product not found");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
