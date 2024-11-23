package com.example.productservice.service;

import java.util.List;

import com.example.productservice.exception.ProductNotfoundException;
import com.example.productservice.model.Product;


public interface ProductService
{
	Product getProductById(long id) throws ProductNotfoundException;

	List<Product> getAllProducts();

	Product replaceProduct(Long id, Product product);

	Product updateProduct(Long id, Product product);

	Product deleteProduct(Long id);

	Product createProduct(Product product);
}
