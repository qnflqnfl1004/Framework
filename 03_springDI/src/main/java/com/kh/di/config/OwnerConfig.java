package com.kh.di.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kh.di.owner.Owner;
import com.kh.di.pet.Pet;

@Configuration
public class OwnerConfig {
	@Bean("ss")
	public Owner owner(@Autowired @Qualifier("dog") Pet pet) {
		return new Owner("신영은", 29, pet);
	}
	
	@Bean // 별도의 ID를 지정해주지 않으면 메소드명으로 ID를 지정한다.
	public Owner dd(/*@Autowired*/ Pet pet) {
		Owner owner = new Owner();
		
		owner.setName("홍길동");
		owner.setAge(24);
		owner.setPet(pet);
		
		return owner;
	}
}
