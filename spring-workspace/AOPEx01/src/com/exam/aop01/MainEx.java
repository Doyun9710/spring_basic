package com.exam.aop01;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.exam.aop01.model.Action;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext( new FileSystemResource( "./src/com/exam/aop01/context.xml" ) );
		
		//Action action = ctx.getBean( "writeAction", Action.class );
		Action action = ctx.getBean( "proxy1", Action.class );
		//Action action = ctx.getBean( "proxy2", Action.class );
		
		// 전처리 -> AOP
		action.execute();
		action.execute11();
		action.execute12();
		
		// 후처리
		
		ctx.close();
	}

}
