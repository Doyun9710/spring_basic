package com.exam.di05;

public class HelloBean {
	public HelloBean() {
		// TODO Auto-generated constructor stub
		System.out.println( "HelloBean 생성자 호출" );
	}
	
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println( name + "님 안녕하세요" );
	}
}
