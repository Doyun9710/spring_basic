package com.exam.lifecycle.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WriteAction implements Action, InitializingBean, DisposableBean, ApplicationContextAware, BeanNameAware, BeanClassLoaderAware, BeanFactoryAware {
	private String writer;
	
	// life cycle 진행상황 보기
	private String beanName;
	private BeanFactory beanFactory;
	
	public WriteAction() {
		// TODO Auto-generated constructor stub
		System.out.println( "1. 빈의 생성자 실행" );
	}
	
	public void setWriter(String writer) {
		System.out.println( "2. setWriter(String writer) 실행" );
		this.writer = writer;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println( "*. execute() 실행" );
		System.out.println( "writer : " + writer );
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println( "5. setBeanFactory(BeanFactory beanFactory) 실행 : 빈 팩토리 설정(빈 생산 공장)" );
		this.beanFactory = beanFactory;
		System.out.println( "beanFactory : " + beanFactory );
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		// TODO Auto-generated method stub
		System.out.println( "4. setBeanClassLoader(ClassLoader classLoader)" );
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println( "3. setBeanName(String name) 실행 : 빈의 이름 설정" );
		this.beanName = name;
		System.out.println( "beanName : " + beanName );
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println( "6. setApplicationContext(ApplicationContext applicationContext)" );
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "11. destroy()" );
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "8. afterPropertiesSet() 실행" );
		
		if( writer == null ) {
			throw new IllegalArgumentException( "writer 가 필요합니다." );
		} else {
			System.out.println( "writer 가 설정되었습니다." );
		}
	}
	
	// 사용자 메서드
	public void init_method() {
		System.out.println( "9. 빈의 사용자 초기화 메서드" );
	}
	
	public void destroy_method() {
		System.out.println( "12. 빈의 사용자 소멸 메서드" );
	}

}
