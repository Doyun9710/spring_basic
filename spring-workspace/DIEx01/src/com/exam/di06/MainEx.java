package com.exam.di06;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericXmlApplicationContext ctx 
		//= new GenericXmlApplicationContext( new FileSystemResource( "C:/Java/spring-workspace/DIEx01/src/com/exam/di06/context.xml" ) );
		= new GenericXmlApplicationContext( new FileSystemResource( "./src/com/exam/di06/context.xml" ) );

		HelloBean hello1 = (HelloBean)ctx.getBean( "hello1" );
		hello1.sayHello();
		
		HelloBean hello2 = (HelloBean)ctx.getBean( "hello2" );
		hello2.sayHello();
		
		HelloBean hello3 = (HelloBean)ctx.getBean( "hello3" );
		hello3.sayHello();
		
		ctx.close();
	}

}
