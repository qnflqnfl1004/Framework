package com.kh.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


// alt + shift + r (파일명, 클래스명 변경)

@Configuration
@Import(value = {
		OwnerConfig.class,
		PetConfig.class
})
// basePackage를 지정하지 않으면 현재 Package가 basePackage가 된다.
@ComponentScan("com.kh.di")
public class RootConfig {
	@Bean
	public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		PropertySourcesPlaceholderConfigurer configurer;
		Resource[] resources;
		
		configurer = new PropertySourcesPlaceholderConfigurer();
		resources = new ClassPathResource[] {
			new ClassPathResource("character.properties"),
			new ClassPathResource("driver.properties")
		};
		
		configurer.setLocations(resources);
		
		return configurer;
	}
}
