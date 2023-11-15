package com.exam.di01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.exam.di01.model.Hello;
import com.exam.di01.model.HelloBean1;
import com.exam.di01.model.HelloBean2;

// 초기 설정 ...
//@Configuration
//@Scope( "prototype" )
public class BeanConfig {
	
	// 방법 1
	@Bean
	//@Scope( value="prototype" )
	public HelloBean1 helloBean1() {
		return new HelloBean1();
	}
	
	@Bean
	//@Scope( value="prototype" )
	public HelloBean2 helloBean2() {
		return new HelloBean2();
	}
	
	// 방법 2 - 다형성(어떤 객체의 속성이나 기능이 상황에 따라 여러 가지 형태를 가질 수 있는 성질)
	@Bean
	public Hello hello1() {
		return new HelloBean1();
	}
	
	@Bean
	public Hello hello2() {
		return new HelloBean2();
	}
	
	// Option. 호출 hello3(X), hello(O)
	@Bean(name="hello")
	public Hello hello3() {
		return new HelloBean1();
	}
}
