package com.exam.di06_fz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.exam.di06_fz.model.BoardDAO;
import com.exam.di06_fz.model.WriteAction;

@Configuration
public class BeanConfig {
	
	@Bean
	public BoardDAO dao() {
		System.out.println( "dao() 호출" );
		return new BoardDAO();
	}
	
	@Bean
	public WriteAction writeAction() {
		return new WriteAction();
	}
	
}





