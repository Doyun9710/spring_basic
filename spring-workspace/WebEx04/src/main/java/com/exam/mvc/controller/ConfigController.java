package com.exam.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController {
	
	@RequestMapping( "/form.do" )
	public String form() {
		System.out.println( "form() 호출" );
		
		return "form";
	}
	/*
	@RequestMapping( "/form_ok.do" )
	public String form_ok() {
		System.out.println( "form_ok() 호출" );
		
		return "form_ok";
	}
	*/
	@GetMapping( "/form_ok.do" )
	public String form_get_ok() {
		System.out.println( "form_get_ok() 호출" );
		return "form_ok";
	}
	
	@PostMapping( "/form_ok.do" )
	public String form_post_ok() {
		System.out.println( "form_post_ok() 호출" );
		return "form_ok";
	}
	
}
