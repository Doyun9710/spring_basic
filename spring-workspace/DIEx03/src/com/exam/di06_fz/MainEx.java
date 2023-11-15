package com.exam.di06_fz;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.di06_fz.config.BeanConfig;
import com.exam.di06_fz.model.WriteAction;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx
		= new AnnotationConfigApplicationContext( BeanConfig.class );
		
		WriteAction writeAction
			= (WriteAction)ctx.getBean( "writeAction" );
		writeAction.getDao();
		
		ctx.close();

	}
}



