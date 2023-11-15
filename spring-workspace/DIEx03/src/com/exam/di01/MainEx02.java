package com.exam.di01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.exam.di01.config.BeanConfig;
import com.exam.di01.model.Hello;
import com.exam.di01.model.HelloBean1;
import com.exam.di01.model.HelloBean2;

public class MainEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ctx 
		= new AnnotationConfigApplicationContext( BeanConfig.class );
		
		//HelloBean1 helloBean1 = (HelloBean1)ctx.getBean( "helloBean1" );
		HelloBean1 helloBean1 = ctx.getBean( "helloBean1", HelloBean1.class );
		helloBean1.sayHello( "홍길동" );
		
		//HelloBean2 helloBean2 = (HelloBean2)ctx.getBean( "helloBean2" );
		HelloBean2 helloBean2 = ctx.getBean( "helloBean2", HelloBean2.class );
		helloBean2.sayHello( "김철수" );
		
		HelloBean1 helloBean3 = (HelloBean1)ctx.getBean( "helloBean1" );
		helloBean3.sayHello( "홍길동" );

		// Default scope : singleton, helloBean1 == helloBean3
		System.out.println( "helloBean1 : " + helloBean1 );
		System.out.println( "helloBean2 : " + helloBean2 );
		System.out.println( "helloBean3 : " + helloBean3 );
		
		ctx.close();
	}

}
