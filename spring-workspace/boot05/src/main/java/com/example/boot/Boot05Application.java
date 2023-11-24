package com.example.boot;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.mapper.SqlMapperInter;

@SpringBootApplication
@MapperScan( basePackages = { "com.example.mapper" } )
public class Boot05Application implements CommandLineRunner {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private SqlMapperInter mapper;

	public static void main(String[] args) {
		SpringApplication.run(Boot05Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "mapper : " + mapper );
		
		//select1();
		
		String result = mapper.select();
		System.out.println( "결과 : " + result );
	}
	
	public void select1()throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations( 
				applicationContext.getResources( "classpath:/mappers/mapper.xml" ) 
		);
		
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
		
		SqlSession sqlSession = sqlSessionFactory.openSession( true );
		
		System.out.println( "sqlSession : " + sqlSession );
		
		String result = sqlSession.selectOne( "select" );
		System.out.println( "결과 : " + result );
		
		sqlSession.close();
	}

}
