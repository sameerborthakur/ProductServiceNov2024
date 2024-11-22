package com.example.productservice.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Category extends BaseModel
{
	String description;
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	List<Product> products;
}
