package com.example.productservice.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@DiscriminatorValue(value = "3")
public class Students extends User
{
	String course;
	String batch;
}
