package com.exam.di02;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext( new FileSystemResource( "./src/com/exam/di02/context.xml" ) );
		/*
		WriteAction writeAction1 = (WriteAction)ctx.getBean( "writeAction1" );
		System.out.println( "wrtieAction1 : " + writeAction1 );
		*/
		ListAction listAction = (ListAction)ctx.getBean( "listAction" );
		System.out.println( "listAction : " + listAction );
		listAction.execute();
		
		ctx.close();
	}

}
