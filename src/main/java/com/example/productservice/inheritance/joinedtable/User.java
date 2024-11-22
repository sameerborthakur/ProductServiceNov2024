package com.example.productservice.inheritance.joinedtable;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "jt_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User
{
	@Id
	long id;
	String name;
	String email;
	String password;

}
