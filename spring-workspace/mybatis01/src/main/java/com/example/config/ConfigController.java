package com.example.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigController {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private ApplicationContext applicationContext;

	@RequestMapping( "/jdbc.do" )
	public ModelAndView jdbc1() {
		
		try {
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView( "jdbc" );
	}
	
}
