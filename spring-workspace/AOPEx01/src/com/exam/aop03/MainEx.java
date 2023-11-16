package com.exam.aop03;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.exam.aop03.model.Action;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext( new FileSystemResource( "./src/com/exam/aop03/context.xml" ) );

		Action action = ctx.getBean( "writeAction", Action.class );
		
		action.execute();
	}

}
