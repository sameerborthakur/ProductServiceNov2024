package com.example.productservice.controller;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.productservice.exception.ProductNotfoundException;
import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
public class ProductControllerTest
{
	@MockBean(name = "SelfProductService")
	ProductService productService;

	@Autowired
	ProductController productController;

	// Add your tests here
	@Test
	void whenGetProductByIdIsCalled() throws ProductNotfoundException
	{
		//Arrange
		Product product = new Product();
		product.setId(1L);
		product.setTitle("Product 1");
		product.setDescription("Product 1 description");

		when(productService.getProductById(1L)).thenReturn(product);

		//Act
		Product productReturned = productController.getProduct(1L);

		//Assert
		Assertions.assertEquals(product.getTitle(), productReturned.getTitle());
	}

	@Test
	void whenGetAllProductsIsCalled()
	{
		//Arrange
		Product product1 = new Product();
		product1.setId(1L);
		product1.setTitle("Product 1");
		product1.setDescription("Product 1 description");

		Product product2 = new Product();
		product2.setId(2L);
		product2.setTitle("Product 2");
		product2.setDescription("Product 2 description");

		when(productService.getAllProducts()).thenReturn(List.of(product1, product2));

		//Act
		List<Product> products = productController.getAllProducts();

		//Assert
		Assertions.assertEquals(2, products.size());
	}

}
