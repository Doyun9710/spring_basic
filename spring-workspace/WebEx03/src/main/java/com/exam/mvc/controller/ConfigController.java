package com.exam.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController {
	
	@RequestMapping( "/list1.do" )
	public String handleRequest1() {
		System.out.println( "handleRequest1() 호출" );
		
		return "listview1";
	}
	
	@RequestMapping( "/list2.do" )
	public String handleRequest2() {
		System.out.println( "handleRequest2() 호출" );
		
		return "listview2";
	}

}
