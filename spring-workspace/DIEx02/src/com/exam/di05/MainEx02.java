package com.exam.di05;

import java.util.ArrayList;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class MainEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext( new FileSystemResource( "./src/com/exam/di05/context.xml" ) );

		BoardListTO listTO = (BoardListTO)ctx.getBean( "listTO" );
		for( String user : listTO.getUserLists() ) {
			System.out.println( user );
		}
		for( BoardTO to : listTO.getBoardLists() ) {
			System.out.print( to.getSeq() + "\t" );
			System.out.println( to.getSubject() );
		}
		
		ctx.close();
	}

}
