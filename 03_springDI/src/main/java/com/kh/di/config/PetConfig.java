package com.kh.di.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.kh.di.pet.Cat;
import com.kh.di.pet.Dog;

@Configuration
public class PetConfig {
	@Bean
	public Dog dog() {
		return new Dog("배추");
	}
	
	@Bean
	@Primary /*@Qualifier("cat")  없어도 실행 될수있게 만듦*/
	public Cat cat() {
		Cat cat = new Cat();
		
		cat.setName("부추");
		
		return cat;
	}
}
