package com.example.boot;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Boot06Application implements CommandLineRunner {

	@Autowired
	private SqlSession sqlSession;
	
	public static void main(String[] args) {
		SpringApplication.run(Boot06Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println( "sqlSession : " + sqlSession );
		
		String result = sqlSession.selectOne( "select" );
		System.out.println( "결과 : " + result );
		
	}

}
