package com.example.productservice.inheritance.singletable;

import javax.management.DescriptorKey;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@DiscriminatorValue(value = "2")
public class Mentor extends User
{
	public String company;
	public int avgRating;
}
