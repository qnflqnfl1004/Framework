package com.kh.aop.pet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kh.aop.annotation.NoLogging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Component
//@NoLogging
public class Cat extends Pet {
	@Value("나비")
	private String name;
	
	@Override
	@NoLogging
	public String bark() {
		return "으갸아아컄컁캬양";	
	}
}
