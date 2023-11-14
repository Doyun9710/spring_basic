package com.exam.di06;

public class HelloBean {
	private String name;
	
	// Default constructor
	public HelloBean() {
		// TODO Auto-generated constructor stub
		System.out.println( "HelloBean 생성자 호출" );
	}
	
	public HelloBean(String name) {
		// TODO Auto-generated constructor stub
		System.out.println( "HelloBean(String name) 생성자 호출" );
		this.name = name;
	}
	
	public HelloBean(String firstname, String lastname) {
		System.out.println( "HelloBean(String firstname, String lastname) 생성자 호출" );
		this.name = lastname + " " + firstname;
	}
	
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println( name + "님 안녕하세요" );
	}
}
