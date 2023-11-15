package com.exam.di03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.exam.di03.config.BeanConfig;
import com.exam.di03.model1.WriteAction;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext ctx 
		= new AnnotationConfigApplicationContext( BeanConfig.class );

		WriteAction writeAction = ctx.getBean( "writeAction", WriteAction.class );
		
		ctx.close();
	}

}
