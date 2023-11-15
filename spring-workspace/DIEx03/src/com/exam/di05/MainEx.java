package com.exam.di05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.di05.model.HelloBean1;
import com.exam.di05.model.HelloBean2;
import com.exam.di05.config.BeanConfig;
import com.exam.di05.config.BeanConfig1;
import com.exam.di05.config.BeanConfig2;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx 
		//= new AnnotationConfigApplicationContext( BeanConfig1.class, BeanConfig2.class );
		//= new AnnotationConfigApplicationContext( BeanConfig.class );
		= new AnnotationConfigApplicationContext( BeanConfig1.class );
		
		HelloBean1 helloBean1 = (HelloBean1)ctx.getBean( "helloBean1" );
		helloBean1.sayHello( "홍길동" );
		
		HelloBean2 helloBean2 = (HelloBean2)ctx.getBean( "helloBean2" );
		helloBean2.sayHello( "김철수" );
		
		ctx.close();
	}

}
