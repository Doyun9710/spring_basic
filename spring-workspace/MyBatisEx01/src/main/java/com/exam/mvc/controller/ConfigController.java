package com.exam.mvc.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.mvc.model.JdbcDAO;

@Controller
public class ConfigController { 
	
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private JdbcDAO dao;

	@RequestMapping( "/mybatis.do" )
	public String mybatis() {
		System.out.println( "mybatis() 호출" );
		
		System.out.println( "sqlSession : " + sqlSession );
		/*
		String result = sqlSession.selectOne( "selectNow" );
		System.out.println( "결과 : " + result );
		*/
		dao.selectNow();
		
		return "mybatis";
	}
	
}






