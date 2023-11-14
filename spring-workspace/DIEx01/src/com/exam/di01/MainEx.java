package com.exam.di01;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 객체 생성 / 사용 / 소멸
		HelloBean1 hello1 = new HelloBean1();
		hello1.sayHello( "홍길동" );
		
		HelloBean2 hello2 = new HelloBean2();
		hello2.sayHello( "김철수" );
		
		hello1 = null;
		hello2 = null;
	}

}
