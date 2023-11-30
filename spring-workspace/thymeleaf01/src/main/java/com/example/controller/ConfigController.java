package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigController {
	
	@GetMapping( "/view1.do" )
	public ModelAndView view1() {
		return new ModelAndView( "view1" );
	}

	@GetMapping( "/view2.do" )
	public ModelAndView view2() {
		return new ModelAndView( "view2" );
	}
	
}
