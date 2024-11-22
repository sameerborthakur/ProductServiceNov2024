package com.example.productservice.inheritance.tableperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "tpc_students")
public class Students extends User
{
	String course;
	String batch;
}
