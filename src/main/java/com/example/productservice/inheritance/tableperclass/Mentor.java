package com.example.productservice.inheritance.tableperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "tpc_mentor")
public class Mentor extends User
{
	public String company;
	public int avgRating;
}
