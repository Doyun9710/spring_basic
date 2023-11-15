package com.exam.di06.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import( BoardDAO.class )
public class BeanConfig {
	
	// 내부적 자동 인스턴스화
	// Constructor / Property 주입
	@Autowired
	private BoardDAO dao;
	
	@Bean
	public WriteAction writeAction1() {
		return new WriteAction();
	}
	
	@Bean
	public WriteAction writeAction2() {
		return new WriteAction( new BoardDAO() );
	}
	
	@Bean
	public WriteAction writeAction3() {
		System.out.println( "dao : " + dao );
		return new WriteAction();
	}
}
