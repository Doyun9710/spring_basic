package com.exam.di03.model1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardTO {
	private String seq;
	private String subject;
	
	public BoardTO() {
		// TODO Auto-generated constructor stub
		System.out.println( "BoardTO() 호출" );
	}
}
