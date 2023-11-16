package com.exam.aop03.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class BasicAdvice1 {

	@Around( "execution(* execute())" )
	public Object logAround( ProceedingJoinPoint joinPoint ) throws Throwable {
		
		System.out.println( "전처리 구간 1" );
		
		Object rtnObj = joinPoint.proceed();

		System.out.println( "후처리 구간 1" );
		
		return rtnObj;
	}
}
