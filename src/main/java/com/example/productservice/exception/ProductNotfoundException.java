package com.example.productservice.exception;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductNotfoundException extends Exception
{
	private Long id;
	public ProductNotfoundException(Long id ,String message)
	{
		super(message);
		this.id = id;
	}
}
