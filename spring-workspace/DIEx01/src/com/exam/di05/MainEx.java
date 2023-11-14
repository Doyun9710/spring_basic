package com.exam.di05;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext( new FileSystemResource( "C:/Java/spring-workspace/DIEx01/src/com/exam/di05/context.xml" ) );
		
		// new 두 번
		HelloBean hello11 = (HelloBean)ctx.getBean( "hello11" );
		HelloBean hello12 = (HelloBean)ctx.getBean( "hello12" );
		
		hello11.sayHello( "홍길동" );
		System.out.println( "hello11 : " + hello11 );
		hello12.sayHello( "김철수" );
		System.out.println( "hello12 : " + hello12 );
		
		// Prototype : hello11 != hello13
		HelloBean hello13 = (HelloBean)ctx.getBean( "hello11" );
		hello12.sayHello( "김영희" );
		System.out.println( "hello13 : " + hello13 );
		
		
		
		HelloBean hello21 = (HelloBean)ctx.getBean( "hello21" );
		HelloBean hello22 = (HelloBean)ctx.getBean( "hello22" );
		System.out.println( "hello21 : " + hello21 );
		System.out.println( "hello22 : " + hello22 );
		
		// Singleton : hello21 == hello23
		HelloBean hello23 = (HelloBean)ctx.getBean( "hello21" );
		System.out.println( "hello23 : " + hello23 );
		
		ctx.close();
	}

}
