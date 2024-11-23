package com.example.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.exception.ProductNotfoundException;
import com.example.productservice.model.Product;
import com.example.productservice.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController
{
	ProductService productService;

	ProductController(@Qualifier("SelfProductService") ProductService productService){
		this.productService=productService;
	}

	@GetMapping("/{id}")
	Product getProduct(@PathVariable("id") Long id) throws ProductNotfoundException
	{
		return productService.getProductById(id);
	}

	@GetMapping
	List<Product> getAllProducts(){
		return productService.getAllProducts();
	}

	@PutMapping("/{id}")
	Product replaceProduct(@RequestBody Product product, @PathVariable("id") Long id){
		return productService.replaceProduct(id,product);
	}

	@PatchMapping("/{id}")
	Product updateProduct(@RequestBody Product product, @PathVariable("id") Long id){
		return productService.updateProduct(id,product);
	}

	@DeleteMapping("/{id}")
	Product deleteProduct(@PathVariable("id") Long id){
		return productService.deleteProduct(id);
	}


	@PostMapping
	Product createProduct(@RequestBody Product product){
		return productService.createProduct(product);
	}

}
