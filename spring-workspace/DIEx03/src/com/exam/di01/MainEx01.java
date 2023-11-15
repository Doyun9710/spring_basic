package com.exam.di01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.exam.di01.config.BeanConfig;
import com.exam.di01.model.Hello;
import com.exam.di01.model.HelloBean1;
import com.exam.di01.model.HelloBean2;

public class MainEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ctx 
		= new AnnotationConfigApplicationContext( BeanConfig.class );
		
		HelloBean1 helloBean1 = (HelloBean1)ctx.getBean( "helloBean1" );
		helloBean1.sayHello( "홍길동" );
		
		HelloBean2 helloBean2 = (HelloBean2)ctx.getBean( "helloBean2" );
		helloBean2.sayHello( "김철수" );
		
		// 다형성(어떤 객체의 속성이나 기능이 상황에 따라 여러 가지 형태를 가질 수 있는 성질)
		Hello hello = (Hello)ctx.getBean( "hello1" );
		hello.sayHello( "홍길동" );
		
		hello = (Hello)ctx.getBean( "hello2" );
		hello.sayHello( "김철수" );
		
		// Error. [Option] @Bean(name="hello")
		// hello = (Hello)ctx.getBean( "hello3" );
		hello = (Hello)ctx.getBean( "hello" );
		hello.sayHello( "김영희" );
		
		ctx.close();
	}

}
