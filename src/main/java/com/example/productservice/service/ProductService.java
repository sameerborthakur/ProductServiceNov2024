package com.example.productservice.service;

import java.util.List;

import com.example.productservice.model.Product;


public interface ProductService
{
	Product getProoductById(long id);

	List<Product> getAllProducts();

	Product replaceProduct(Long id, Product product);
}
