package com.example.productservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController
{
	ProductService productService;

	ProductController(ProductService productService){
		this.productService=productService;
	}

	@GetMapping("/{id}")
	Product getProduct(@PathVariable("id") Long id){
		return productService.getProoductById(id);
	}

	@GetMapping
	List<Product> getAllProducts(){
		return productService.getAllProducts();
	}

	@PutMapping("/{id}")
	Product replaceProduct(@RequestBody Product product, @PathVariable("id") Long id){
		return productService.replaceProduct(id,product);
	}
}
