package com.exam.di04;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WriteAction {
	private BoardTO to;
	
	public void execute() {
		System.out.println( "WriteAction execute() to.getSeq() : " + to.getSeq() );
		System.out.println( "WriteAction execute() to.getSubject() : " + to.getSubject() );
	}
}
