package com.exam.di05.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.exam.di05.model.HelloBean1;

@Import( { BeanConfig2.class } )
public class BeanConfig1 {

	@Bean
	//@Scope( value="prototype" )
	public HelloBean1 helloBean1() {
		return new HelloBean1();
	}
	
}
