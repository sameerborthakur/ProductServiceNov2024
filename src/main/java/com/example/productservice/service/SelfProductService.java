package com.example.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.productservice.exception.ProductNotfoundException;
import com.example.productservice.model.Category;
import com.example.productservice.model.Product;
import com.example.productservice.projection.ProductTitleAndDescription;
import com.example.productservice.repository.CategoryRepository;
import com.example.productservice.repository.ProductRepository;

@Service("SelfProductService")
public class SelfProductService implements ProductService
{
	ProductRepository productRepository;
	CategoryRepository categoryRepository;

	SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository)
	{
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}


	@Override
	public Product getProductById(long id) throws ProductNotfoundException
	{
		//ProductTitleAndDescription projection = productRepository.getProductTitleAndDescriptionById(id);
		ProductTitleAndDescription projection = productRepository.getProductTitleAndDescriptionSQLById(id);
		Product p = new Product();
		p.setTitle(projection.getTitle());
		p.setDescription(projection.getDescription());
		return p;
		/*Optional<Product> product = productRepository.findById(id);
		if(product.isPresent())
		{
			return product.get();
		}else{
			throw new ProductNotfoundException(100L, "Product with id "+id+" not found");
		}*/
	}

	@Override
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}

	@Override
	public Product replaceProduct(Long id, Product product)
	{
		return productRepository.findById(id).map(p -> {
			p.setId(product.getId());
			p.setPrice(product.getPrice());
			p.setCategory(product.getCategory());
			return productRepository.save(p);
		}).orElse(null);
	}

	@Override
	public Product updateProduct(Long id, Product product)
	{
		return productRepository.findById(id).map(p -> {
			p.setId(product.getId());
			p.setPrice(product.getPrice());
			p.setCategory(product.getCategory());
			return productRepository.save(p);
		}).orElse(null);
	}

	@Override
	public Product deleteProduct(Long id)
	{
		Optional<Product> product= productRepository.findById(id);
		if(product.isPresent())
		{
			productRepository.deleteById(id);
			return product.get();
		}
		return null;
	}

	@Override
	public Product createProduct(Product product)
	{
		//Category category = product.getCategory();
		//product.setCategory(categoryRepository.save(category));
		return productRepository.save(product);
	}
}
