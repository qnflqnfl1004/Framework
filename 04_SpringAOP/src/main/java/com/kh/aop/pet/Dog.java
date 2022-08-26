package com.kh.aop.pet;

import java.lang.annotation.Repeatable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.kh.aop.annotation.Repeat;

import lombok.Getter;
import lombok.ToString;

@Getter
@Primary
@ToString
@Component
public class Dog extends Pet{
	@Value("짱구")
	public String name;
	
	@Override
	@Repeat(count = 5)
	public String bark() throws Exception {
		
//		if(true) {
//			throw new Exception();
//		}
		
		return "왈왈그러렁컹컹월!";	
	}
}
