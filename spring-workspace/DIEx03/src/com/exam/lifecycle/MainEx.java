package com.exam.lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.exam.lifecycle.model.Action;

public class MainEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 컨테이너 시작 -> 빈 생성(+초기화)
		GenericXmlApplicationContext ctx 
		= new GenericXmlApplicationContext( new FileSystemResource( "./src/com/exam/lifecycle/context.xml" ) );
		
		Action action = ctx.getBean( "writeAction", Action.class );
		action.execute();
		
		// 빈 삭제
		ctx.removeBeanDefinition( "writeAction" );
		
		// 컨테이너 종료
		ctx.close();
	}

}
