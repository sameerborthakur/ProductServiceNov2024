package com.example.productservice.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "mps_students")
public class Students extends User
{
	String course;
	String batch;
}
