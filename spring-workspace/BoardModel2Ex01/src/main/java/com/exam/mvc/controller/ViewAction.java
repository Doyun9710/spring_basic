package com.exam.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.exam.mvc.model.BoardDAO;
import com.exam.mvc.model.BoardTO;

public class ViewAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "ViewAction handleRequest() 호출");
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardView( to );
		
		//request.setAttribute( "to", to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_view1" );
		modelAndView.addObject( "to", to );
		
		return modelAndView;
	}

}
