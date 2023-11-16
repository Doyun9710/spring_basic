package com.exam.aop02.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class BasicAdvice2 {
	public Object logAround( ProceedingJoinPoint joinPoint ) throws Throwable {
		
		System.out.println( "전처리 구간 2" );
		
		Object rtnObj = joinPoint.proceed();

		System.out.println( "후처리 구간 2" );
		
		return rtnObj;
	}
}
