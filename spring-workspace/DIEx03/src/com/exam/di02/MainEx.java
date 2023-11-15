package com.exam.di02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.exam.di02.config.BeanConfig;
import com.exam.di02.model.Hello;
import com.exam.di02.model.HelloBean;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ctx 
		= new AnnotationConfigApplicationContext( BeanConfig.class );

		HelloBean helloBean1 = ctx.getBean( "helloBean1", HelloBean.class );
		helloBean1.sayHello();
		
		// 생성자 주입, HelloBean( "김철수" )
		HelloBean helloBean2 = ctx.getBean( "helloBean2", HelloBean.class );
		helloBean2.sayHello();
		
		ctx.close();
	}

}
