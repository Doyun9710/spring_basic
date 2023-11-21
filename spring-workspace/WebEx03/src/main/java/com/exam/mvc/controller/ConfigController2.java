package com.exam.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController2 {

	@RequestMapping( "/view1/list1.do" )
	public String handleRequest3() {
		System.out.println( "handleRequest3() 호출" );
		
		return "listview1";
	}
	
	@RequestMapping( "/view1/list2.do" )
	public String handleRequest4() {
		System.out.println( "handleRequest4() 호출" );
		
		return "listview2";
	}
}
