package com.example.productservice.inheritance.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "jt_mentor")
public class Mentor extends User
{
	public String company;
	public int avgRating;
}
