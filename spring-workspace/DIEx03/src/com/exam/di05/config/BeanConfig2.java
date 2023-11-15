package com.exam.di05.config;

import org.springframework.context.annotation.Bean;

import com.exam.di05.model.HelloBean2;

public class BeanConfig2 {

	@Bean
	//@Scope( value="prototype" )
	public HelloBean2 helloBean2() {
		return new HelloBean2();
	}
}
