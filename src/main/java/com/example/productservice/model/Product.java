package com.example.productservice.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Product
{
	private long id;
	private String title;
	private double price;
	private String desc;
	private Category category;
	private String image;
}