package com.exam.di06.model;

public class WriteAction {
	public WriteAction() {
		// TODO Auto-generated constructor stub
		System.out.println( "WriteAction() 생성자 호출" );
	}
	
	public WriteAction(BoardDAO dao) {
		System.out.println( "WriteAction(BoardDAO dao) 생성자 호출" );
	}
}
