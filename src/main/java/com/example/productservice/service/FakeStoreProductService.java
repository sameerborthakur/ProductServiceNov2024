package com.example.productservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import com.example.productservice.dto.FakeStoreProductDto;
import com.example.productservice.model.Category;
import com.example.productservice.model.Product;

@Service
public class FakeStoreProductService implements ProductService
{
	RestTemplate restTemplate;

	FakeStoreProductService(RestTemplate restTemplate){
		this.restTemplate=restTemplate;
	}

	@Override
	public Product getProoductById(long id)
	{
		FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);

		assert fakeStoreProductDto != null;
		return mapFakeStoreProductDtoToProduct(fakeStoreProductDto);
	}

	@Override
	public List<Product> getAllProducts()
	{
		FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
		List<Product> products = new ArrayList<>();
		for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos){
			Product product = mapFakeStoreProductDtoToProduct(fakeStoreProductDto);
			products.add(product);
		}

		return products;
	}

	@Override
	public Product replaceProduct(Long id, Product product)
	{
		FakeStoreProductDto fakeStoreProductDto = mapProductToFakeStoreProductDto(product);
		RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDto, FakeStoreProductDto.class);
		ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(
				FakeStoreProductDto.class);
		ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.execute("https://fakestoreapi.com/products/" + id,
				HttpMethod.PUT, requestCallback, responseExtractor);
		FakeStoreProductDto updatedFakeStoreProductDto = responseEntity.getBody();
		return mapFakeStoreProductDtoToProduct(updatedFakeStoreProductDto);
	}

	private FakeStoreProductDto mapProductToFakeStoreProductDto(Product product)
	{
		FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
		fakeStoreProductDto.setId(product.getId());
		fakeStoreProductDto.setTitle(product.getTitle());
		fakeStoreProductDto.setPrice(product.getPrice());
		fakeStoreProductDto.setDescription(product.getDesc());;
		return fakeStoreProductDto;
	}

	private Product mapFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto)
	{
		Product product=new Product();
		product.setId(fakeStoreProductDto.getId());
		product.setTitle(fakeStoreProductDto.getTitle());
		product.setDesc(fakeStoreProductDto.getDescription());
		product.setPrice(fakeStoreProductDto.getPrice());
		product.setImage(fakeStoreProductDto.getImage());
		Category category = new Category();
		category.setId(fakeStoreProductDto.getCategory());
		product.setCategory(category);
		return product;
	}
}