package com.kh.di.owner;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kh.di.pet.Cat;
import com.kh.di.pet.Dog;

class OwnerTest {

	@Test
	@Disabled
	void nothing() {
	}
	
	@Test
	public void create() {
		// 기존에 자바 애플리케이션에서는 다형서을 통해서 객체간의 결합도를 느슨하게 만들어준다.
		// 생성자를 통한 의존성 주입
		Owner owner = new Owner("신영은", 29, new Cat("부추"));
		
		// 메소드를 통한 DI(의존성 주입)
//		owner.setDog(new Dog("배추"));
//		owner.setCat(new Cat("부추"));
//		owner.setPet(new Cat("부추"));
		
		assertThat(owner).isNotNull();
		assertThat(owner.getName()).isEqualTo("신영은");
		assertThat(owner.getPet()).isNotNull();
	}
	
	@Test
	void contextTest() {
		// 스프링은 애플리케이션 컨텍스트를 활용하여 객체 간의 결합을 느슨하게 만들어준다.
		ApplicationContext context;
		
		context = new GenericXmlApplicationContext("spring/root-context.xml");
//		context = new GenericXmlApplicationContext("classpath:spring/root-context.xml");
//		context = new GenericXmlApplicationContext("file:src/main/resources/spring/root-context.xml");
		
		Owner owner = (Owner) context.getBean("owner");
		
		System.out.println(owner);
		
	}

}
