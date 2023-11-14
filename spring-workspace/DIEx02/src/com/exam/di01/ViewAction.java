package com.exam.di01;

public class ViewAction {
	private String seq;
	private BoardTO to;
	
	public ViewAction(String seq, BoardTO to) {
		// TODO Auto-generated constructor stub
		System.out.println( "ViewAction(String seq, BoardTO to) 생성자 호출" );
		this.seq = seq;
		this.to = to;
	}
	
	public void execute() {
		System.out.println( "ViewAction() seq : " + seq );
		System.out.println( "ViewAction() to : " + to );
	}
}
