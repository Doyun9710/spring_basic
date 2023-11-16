package com.exam.aop03.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BasicAdvice3 {

	@Before( "execution(* execute())" )
	public void before() throws Throwable {
		System.out.println( "전처리 실행" );
	}
	
	@After( "execution(* execute())" )
	public void after() throws Throwable {
		System.out.println( "후처리 실행" );
	}
}
