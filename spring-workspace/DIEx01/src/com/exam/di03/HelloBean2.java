package com.exam.di03;

public class HelloBean2 {
	public HelloBean2() {
		// TODO Auto-generated constructor stub
		System.out.println( "HelloBean2 생성자 호출" );
	}
	
	public void sayHello( String name ) {
		System.out.println( "Hello " + name );
	}
}
