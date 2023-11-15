package com.exam.di06.model;

import org.springframework.beans.factory.annotation.Autowired;

public class WriteAction {
	
	// 내부적 자동 인스턴스화
	// Constructor / Property 주입
	@Autowired
	private BoardDAO dao;
	
	public WriteAction() {
		// TODO Auto-generated constructor stub
		System.out.println( "WriteAction() 생성자 호출" );
		System.out.println( "dao1 : " + dao );
	}
	
	public void getDAO() {
		System.out.println( "dao2 : " + dao );
	}
	/*
	public WriteAction(BoardDAO dao) {
		System.out.println( "WriteAction(BoardDAO dao) 생성자 호출" );
	}
	*/
}
