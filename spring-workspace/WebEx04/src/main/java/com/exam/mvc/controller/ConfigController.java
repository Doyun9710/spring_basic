package com.exam.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigController {
	
	@RequestMapping( "/form.do" )
	public String form() {
		System.out.println( "form() 호출" );
		
		return "form";
	}
	/*
	// 방법 1
	@RequestMapping( "/form_ok.do" )
	public String form_ok(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( "form_ok() 호출 : " + request.getParameter( "data" ) );
		
		request.setAttribute( "data", request.getParameter( "data" ) );
		
		return "form_ok";
	}
	*/
	/*
	// 방법 2
	//@GetMapping( "/form_ok.do" )
	@RequestMapping( value = "/form_ok.do", method = RequestMethod.GET)
	public String form_get_ok() {
		System.out.println( "form_get_ok() 호출" );
		return "form_ok";
	}
	
	//@PostMapping( "/form_ok.do" )
	@RequestMapping( value = "/form_ok.do", method = RequestMethod.POST)
	public String form_post_ok() {
		System.out.println( "form_post_ok() 호출" );
		return "form_ok";
	}
	*/
	/*
	// 방법 3
	@RequestMapping( "/form_ok.do" )
	public ModelAndView form_ok(HttpServletRequest request) {
		System.out.println( "ModelAndView form_ok() 호출 : " + request.getParameter( "data" ) );
		
		String data = request.getParameter( "data" );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "form_ok" );
		modelAndView.addObject( "data", data );
		
		return modelAndView;
	}
	*/
	
	// 방법 4, 5, 6
	@RequestMapping( "/form_ok.do" )
	//public String form_ok(HttpServletRequest request, Model model) {
	//public String form_ok(String data, Model model) {
	public String form_ok(@RequestParam( "data" ) String data, Model model) {
		System.out.println( "ModelAndView form_ok() 호출 : " + data );
		
		model.addAttribute( "data", data );
		
		return "form_ok";
	}
	
}
