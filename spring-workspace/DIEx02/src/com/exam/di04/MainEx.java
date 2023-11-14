package com.exam.di04;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext( new FileSystemResource( "./src/com/exam/di04/context.xml" ) );

		BoardTO to = (BoardTO)ctx.getBean( "to" );
		System.out.println( "to.getSeq() : " + to.getSeq() );
		System.out.println( "to.getSubject() : " + to.getSubject() );
		
		to.setSeq( "2" );
		System.out.println( "to.getSeq() : " + to.getSeq() );

		ctx.close();
	}

}
