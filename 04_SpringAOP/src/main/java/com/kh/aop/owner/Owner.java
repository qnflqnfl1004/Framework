package com.kh.aop.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kh.aop.pet.Pet;

import lombok.Getter;
import lombok.ToString;

@Component
@ToString
@Getter
public class Owner {
	@Value("문인수")
	private String name;
	
	@Value("21")
	private int age;
	
	@Autowired
//	@Qualifier("cat")
	private Pet pet;
	
	
	
}
