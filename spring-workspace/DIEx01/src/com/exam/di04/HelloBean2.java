package com.exam.di04;

public class HelloBean2 implements Hello {

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println( "Hello " + name );
	}

}
