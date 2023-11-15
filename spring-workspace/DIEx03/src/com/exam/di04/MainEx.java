package com.exam.di04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.di04.config.BeanConfig;
import com.exam.di04.model2.ListAction;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ctx 
		= new AnnotationConfigApplicationContext( BeanConfig.class );

		ListAction listAction = (ListAction)ctx.getBean( "listAction" );
		listAction.execute();
		
		ctx.close();
	}

}
