package com.exam.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController { 

	@RequestMapping( "/mybatis.do" )
	public String mybatis() {
		System.out.println( "mybatis() 호출" );

		return "mybatis";
	}
	
}






