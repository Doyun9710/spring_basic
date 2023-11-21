package com.exam.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController {
	
	@RequestMapping( "/form.do" )
	public String handleRequest1() {
		System.out.println( "handleRequest1() 호출" );
		
		return "form";
	}
	
	@RequestMapping( "/form_ok.do" )
	public String handleRequest2() {
		System.out.println( "handleRequest2() 호출" );
		
		return "form_ok";
	}

}
