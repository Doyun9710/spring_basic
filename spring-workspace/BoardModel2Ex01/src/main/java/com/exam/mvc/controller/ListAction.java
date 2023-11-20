package com.exam.mvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.exam.mvc.model.BoardDAO;
import com.exam.mvc.model.BoardTO;

public class ListAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "ListAction handleRequest() 호출");
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardTO> datas = dao.boardList();

		//request.setAttribute( "datas", datas );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_list1" );
		modelAndView.addObject( "datas", datas );
		
		//return new ModelAndView( "list1" );
		return modelAndView;
	}

}
