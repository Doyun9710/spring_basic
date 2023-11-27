package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.JdbcDAO;

@Controller
public class ConfigController {
	
	@Autowired
	private JdbcDAO dao;

	@RequestMapping( "/jdbc1.do" )
	public ModelAndView jdbc1() {
		
		//JdbcDAO dao = new JdbcDAO();
		dao.select();

		return new ModelAndView( "jdbc1" );
	}

}
