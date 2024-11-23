package com.example.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.productservice.model.Product;
import com.example.productservice.projection.ProductTitleAndDescription;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
	//HQL
	@Query("select p.title as title, p.description as description from Product p where p.id = :id")
	ProductTitleAndDescription getProductTitleAndDescriptionById(long id);

	//SQL
	@Query(value = "select p.title as title, p.description as description from Product p where p.id = :id", nativeQuery = true)
	ProductTitleAndDescription getProductTitleAndDescriptionSQLById(long id);
}
