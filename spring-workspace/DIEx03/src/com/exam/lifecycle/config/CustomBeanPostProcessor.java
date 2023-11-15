package com.exam.lifecycle.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println( "10. 초기화 후 빈에 대한 처리" );
		//return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
		return bean;
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println( "7. 초기화 전 빈에 대한 처리" );
		//return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
		return bean;
	}
}
