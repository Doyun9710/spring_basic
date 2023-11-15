package com.exam.di05.model;

public class HelloBean1 implements Hello {

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println( "HelloBean1 " + name );
	}

}
