package com.exam.aop03.model;

public class WriteAction implements Action {
	private String writer;
	
	public WriteAction() {
		// TODO Auto-generated constructor stub
		System.out.println( "WriteAction() 생성자 호출" );
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}

	/** 핵심 기능 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println( "execute() 시작" );
		System.out.println( "Hello " + writer );
		System.out.println( "execute() 끝" );
	}

}
