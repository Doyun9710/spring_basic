package com.exam.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.lifecycle.config.BeanConfig;
import com.exam.lifecycle.model.Action;
import com.exam.lifecycle.model.WriteAction;

public class MainEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx 
		= new AnnotationConfigApplicationContext( BeanConfig.class );
		/*
		// @Bean( id = "writeAction" )
		WriteAction writeAction = (WriteAction)ctx.getBean( "writeAction" );
		writeAction.execute();
		
		ctx.removeBeanDefinition( "writeAction" );
		*/
		Action action = (Action)ctx.getBean( "action", Action.class );
		action.execute();
		
		ctx.removeBeanDefinition( "action" );
		
		ctx.close();
	}

}