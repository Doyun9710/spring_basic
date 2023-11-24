package com.exam.mvc.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.mvc.mapper.SqlMapperInter;

@Controller
@MapperScan( "com.exam.mvc.mapper" )
public class ConfigController { 
	
	@Autowired
	private SqlMapperInter mapper;

	@RequestMapping( "/mybatis.do" )
	public String mybatis() {
		System.out.println( "mybatis() 호출" );
		
		System.out.println( "mapper : " + mapper );
		
		String result = mapper.selectNow();
		System.out.println( "결과 : " + result );

		return "mybatis";
	}
	
}






