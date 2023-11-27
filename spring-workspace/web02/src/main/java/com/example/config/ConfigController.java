package com.example.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ConfigController {

	@RequestMapping( "/form.do" )
	public ModelAndView form() {
		return new ModelAndView( "form" );
	}
	/*
	@RequestMapping( "/form_ok.do" )
	public ModelAndView form_ok() {
		return new ModelAndView( "form_ok" );
	}
	
	@RequestMapping( "/form_ok.do" )
	public String form_ok(HttpServletRequest request) {
		System.out.println( "data : " + request.getParameter( "data" ) );
		return "form_ok";
	}
	
	@RequestMapping( "/form_ok.do" )
	//public String form_ok(@RequestParam( "data" ) String data) {
	public String form_ok(String data) {
		System.out.println( "data : " + data );
		return "form_ok";
	}
	*/
	@RequestMapping( "/form_ok.do" )
	public ModelAndView form_ok(String data, Model model) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "form_ok" );
		model.addAttribute( "data", data );
	
		return modelAndView;
	}
}
