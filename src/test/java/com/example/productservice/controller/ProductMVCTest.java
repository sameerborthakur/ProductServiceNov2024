package com.example.productservice.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;

@WebMvcTest(ProductController.class)
public class ProductMVCTest
{
	@Autowired
	MockMvc mockMvc;

	@MockBean(name = "SelfProductService")
	ProductService productService;

	@Autowired
	ProductController productController;

	@Test
	void whenGetProductByIdIsCalled() throws Exception
	{
		//Arrange
		Product product = new Product();
		product.setId(1L);
		product.setTitle("Product 1");
		product.setDescription("Product 1 description");

		when(productService.getProductById(1L)).thenReturn(product);

		mockMvc.perform(get("/product/1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.title").value("Product 1"));

		verify(productService, times(1)).getProductById(1L);
	}
}
