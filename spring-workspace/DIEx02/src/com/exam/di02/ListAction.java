package com.exam.di02;

public class ListAction {
	private BoardTO to;
	
	public ListAction(BoardTO to) {
		// TODO Auto-generated constructor stub
		System.out.println( "ListAction(BoardTO to) 생성자 호출" );
		this.to = to;
	}
	
	public void execute() {
		System.out.println( "to.getSeq() : " + to.getSeq() );
		System.out.println( "to.getSubject() : " + to.getSubject() );
	}
}
