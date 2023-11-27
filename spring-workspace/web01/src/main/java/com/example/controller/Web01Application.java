package com.example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RestController
@SpringBootApplication
public class Web01Application {

	// Start Server
	public static void main(String[] args) {
		SpringApplication.run(Web01Application.class, args);
	}
	
	// URL Mapping
	/*
	@RequestMapping( "/" )
	public String index() {
		String html = "<h1>Hello Spring Boot</h1>";
		return html;
	}
	
	@RequestMapping( "/hello1.do" )
	public String hello1() {
		String html = "<h1>Hello Spring Boot 1</h1>";
		return html;
	}
	
	@RequestMapping( "/hello2.do" )
	public String hello2() {
		String html = "<h1>Hello Spring Boot 2</h1>";
		return html;
	}
	*/
	
	@RequestMapping( "/hello1.do" )
	public ModelAndView hello1() {
		return new ModelAndView( "hello1" );
	}
}
