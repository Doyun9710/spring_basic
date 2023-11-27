package com.example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@SpringBootApplication
public class Gugudan01Application {

	public static void main(String[] args) {
		SpringApplication.run(Gugudan01Application.class, args);
	}
	
	@RequestMapping( "/gugudan.do" )
	public ModelAndView gugudan() {
		return new ModelAndView( "gugudan" );
	}

	@RequestMapping( "/gugudan_ok.do" )
	public ModelAndView form_ok(@RequestParam( "startdan" ) int startdan, @RequestParam( "enddan" ) int enddan, Model model) {
	//public ModelAndView form_ok(HttpServletRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "gugudan_ok" );
		
		int iStartDan = startdan;
		int iEndDan = enddan;
		/*
		String startDan = request.getParameter( "startdan" );
		String endDan = request.getParameter( "enddan" );
		
		int iStartDan = Integer.parseInt( startDan );
		int iEndDan = Integer.parseInt( endDan );
		*/
		StringBuilder sbHtml = new StringBuilder();
		sbHtml.append( "<table border='1' width='800'>" );
		for( int i=iStartDan ; i<=iEndDan ; i++ ) {
			sbHtml.append( "<tr>" );
			for( int j=1 ; j<=9 ; j++) {
				sbHtml.append( "<td>" + i + "X" + j + "=" + (i*j) + "</td>" );
			}
			sbHtml.append( "</tr>" );
		}
		sbHtml.append( "</table>" );
		
		//request.setAttribute( "result", sbHtml.toString() );
		model.addAttribute( "result", sbHtml.toString() );
		
		return modelAndView;
	}
	

}
