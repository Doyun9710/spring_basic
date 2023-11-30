package com.example.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.BoardTO;

import jakarta.servlet.http.HttpServletRequest;

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

	@GetMapping( "/view3.do" )
	public ModelAndView view3() {
		return new ModelAndView( "view3" );
	}

	@GetMapping( "/view4.do" )
	public ModelAndView view4(HttpServletRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "view4" );
		//modelAndView.addObject( "data1", "난 데이터" );
		
		//request.setAttribute( "data1", "난 데이터" );
		
		model.addAttribute( "data1", "난 데이터 1" );
		
		return modelAndView;
	}
	
	@GetMapping( "/view5.do" )
	public ModelAndView view5() {
		BoardTO to = new BoardTO();
		to.setSeq( "1" );
		to.setSubject( "제목 1" );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "view5" );
		modelAndView.addObject( "to", to );
		
		return modelAndView;
	}
	
	@GetMapping( "/view6.do" )
	public ModelAndView view6() {
		ArrayList<BoardTO> lists = new ArrayList<BoardTO>();
		
		BoardTO to1 = new BoardTO();
		to1.setSeq( "1" );
		to1.setSubject( "제목 1" );
		
		BoardTO to2 = new BoardTO();
		to2.setSeq( "2" );
		to2.setSubject( "제목 2" );
		
		lists.add( to1 );
		lists.add( to2 );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "view6" );
		modelAndView.addObject( "lists", lists );
		
		return modelAndView;
	}
	
}
