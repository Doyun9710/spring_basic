package com.exam.aop03.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class BasicAdvice2 {

	@Around( "execution(* execute())" )
	public Object logAround( ProceedingJoinPoint joinPoint ) throws Throwable {
		
		System.out.println( "전처리 구간 2" );
		
		Object rtnObj = joinPoint.proceed();

		System.out.println( "후처리 구간 2" );
		
		return rtnObj;
	}
}
