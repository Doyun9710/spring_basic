package com.exam.di02.model;

import com.exam.di02.model.Hello;

public class HelloBean implements Hello {

	// 생성자 주입
	private String name;
	
	public HelloBean() {
		// TODO Auto-generated constructor stub
		System.out.println( "HelloBean() 호출" );
		this.name = "홍길동";
	}
	
	public HelloBean(String name) {
		System.out.println( "HelloBean(String name) 호출" );
		this.name = name;
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println( this.name + "님 안녕하세요" );
	}

}
