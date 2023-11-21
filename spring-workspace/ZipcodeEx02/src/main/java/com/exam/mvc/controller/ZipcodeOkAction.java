package com.exam.mvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.exam.mvc.model.ZipcodeDAO;
import com.exam.mvc.model.ZipcodeTO;

public class ZipcodeOkAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println( "ZipcodeOkAction handleRequest() 호출");
		
		String strDong = request.getParameter( "strdong" );
		
		ZipcodeDAO dao = new ZipcodeDAO();
		ArrayList<ZipcodeTO> lists = dao.listZipcode(strDong);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "zipcode_ok" );
		modelAndView.addObject( "lists", lists );
		
		return modelAndView;
	}

}








