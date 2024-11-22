package com.example.productservice.inheritance.mappedsuperclass;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public class User
{
	@Id
	long id;
	String name;
	String email;
	String password;

}
