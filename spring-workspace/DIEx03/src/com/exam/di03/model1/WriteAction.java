package com.exam.di03.model1;

public class WriteAction {
	private BoardTO to;
	
	public WriteAction() {
		// TODO Auto-generated constructor stub
		System.out.println( "WriteAction() 생성자 호출" );
		this.to = new BoardTO();
	}
	
	public WriteAction(BoardTO to) {
		System.out.println( "WriteAction(BoardTO to) 생성자 호출" );
		this.to = to;
	}
}
