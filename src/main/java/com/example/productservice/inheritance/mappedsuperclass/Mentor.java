package com.example.productservice.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "mps_mentor")
public class Mentor extends User
{
	public String company;
	public int avgRating;
}
