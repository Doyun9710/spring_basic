package com.exam.mvc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan( basePackageClasses = { ConfigController.class } )
public class ConfigServlet {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix( "/WEB-INF/views/" );
		viewResolver.setSuffix( ".jsp" );
		
		return viewResolver;
	}
}
