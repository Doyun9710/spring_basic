package com.exam.di06.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.exam.di06.model.BoardDAO;
import com.exam.di06.model.WriteAction;

@Configuration
public class BeanConfig {
	
	@Bean
	public BoardDAO dao() {
		return new BoardDAO();
	}
	
	@Bean
	public WriteAction writeAction1() {
		return new WriteAction();
	}
	/*
	@Bean
	public WriteAction writeAction2() {
		return new WriteAction( new BoardDAO() );
	}
	*/
	@Bean
	public WriteAction writeAction3() {
		//System.out.println( "dao : " + dao );
		return new WriteAction();
	}
	
}
