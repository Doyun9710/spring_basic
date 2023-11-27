package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigController {

	@RequestMapping( "/form.do" )
	public ModelAndView form() {
		return new ModelAndView( "form" );
	}

	@RequestMapping( "/form_ok.do" )
	public ModelAndView form_ok() {
		return new ModelAndView( "form_ok" );
	}

}
