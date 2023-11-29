package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.CommentDAO;
import com.example.model.CommentTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CommentController {

	@Autowired
	private CommentDAO commentdao;
	
	@RequestMapping( "/comment_list.do" )
	public ModelAndView search_comment(HttpServletRequest request, Model model) {
		CommentTO cto = new CommentTO();
		cto.setPseq( request.getParameter( "pseq" ) );
		ArrayList<CommentTO> commentLists = commentdao.boardCommentList( cto );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "comment_list1" );
		model.addAttribute( "commentLists", commentLists );
		
		return modelAndView;
	}
	/*
	@RequestMapping( "/comment_write_ok.do" )
	public ModelAndView write_comment(HttpServletRequest request, Model model) {
		String seq = request.getParameter( "pseq" );
		
		CommentTO cto = new CommentTO();
		cto.setPseq( request.getParameter( "pseq" ) );
		cto.setWriter( request.getParameter( "cwriter" ) );
		cto.setPassword( request.getParameter( "cpassword" ) );
		cto.setContent( request.getParameter( "ccontent" ) );
		int flag = commentdao.boardCommentWriteOk( cto );

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "comment_write1_ok" );
		model.addAttribute( "to", cto );

		return modelAndView;
	}
	*/
	@RequestMapping( "/comment_write_ok.do" )
	@ResponseBody
	public Map<String, String> write_comment(HttpServletRequest request, Model model) {
		CommentTO cto = new CommentTO();
		cto.setPseq( request.getParameter( "pseq" ) );
		cto.setWriter( request.getParameter( "cwriter" ) );
		cto.setPassword( request.getParameter( "cpassword" ) );
		cto.setContent( request.getParameter( "ccontent" ) );
		
		int flag = commentdao.boardCommentWriteOk( cto );
		
		Map<String, String > map = new HashMap<String, String>();
		map.put( "flag", flag+"" );
		return map;
	}
	
	@RequestMapping( "/cmt_delete_ok.do" )
	@ResponseBody
	public Map<String, String> cmt_delete_ok(HttpServletRequest request) {
		CommentTO cto = new CommentTO();
		cto.setPseq( request.getParameter( "seq" ) );
		
		int flag = commentdao.boardCommentDeleteOk( cto );
		
		Map<String, String> map = new HashMap<String, String>();
		map.put( "flag", flag + "" );
		return map;
	}
	
	@RequestMapping( "/json1.do" )
	@ResponseBody
	public Map<String, String> json1() {
		Map<String, String > map = new HashMap<String, String>();
		map.put( "data1", "value1" );
		map.put( "data2", "value2" );
		return map;
	}
	
	@RequestMapping( "/json2.do" )
	@ResponseBody
	public ModelMap json2() {
		ModelMap model = new ModelMap();
		model.addAttribute( "data1", "value1" );
		model.addAttribute( "data2", "value2" );
		return model;
	}
	
	@RequestMapping( "/json3.do" )
	public String json3(ModelMap model) {
		model.addAttribute( "data1", "value1" );
		model.addAttribute( "data2", "value2" );
		return "jsonView";
	}
}
