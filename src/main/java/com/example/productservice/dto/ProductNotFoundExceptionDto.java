package com.example.productservice.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductNotFoundExceptionDto
{
	private Long errorCode;
	private String message;
}
