package com.exam.aop03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.exam.aop03.advice.BasicAdvice1;
import com.exam.aop03.advice.BasicAdvice2;
import com.exam.aop03.advice.BasicAdvice3;
import com.exam.aop03.model.WriteAction;

@EnableAspectJAutoProxy
public class BeanConfig {
	
	@Bean
	public WriteAction writeAction() {
		WriteAction writeAction = new WriteAction();
		writeAction.setWriter( "홍길동" );
		return writeAction;
	}
	/*
	@Bean
	public BasicAdvice1 basicAdvice1() {
		return new BasicAdvice1();
	}

	@Bean
	public BasicAdvice2 basicAdvice2() {
		return new BasicAdvice2();
	}
	*/
	@Bean
	public BasicAdvice3 basicAdvice3() {
		return new BasicAdvice3();
	}
}
