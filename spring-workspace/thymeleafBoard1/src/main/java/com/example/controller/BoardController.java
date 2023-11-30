package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.BoardDAO;
import com.example.model.BoardTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {

	@Autowired
	private BoardDAO dao;

	@RequestMapping( "/list.do" )
	public String board_list(HttpServletRequest request, Model model) {
		System.out.println( "board_list() 호출" );

		ArrayList<BoardTO> datas = dao.boardList();

		model.addAttribute( "datas", datas );
		
		return "board_list1";
	}
	
	@RequestMapping( "/view.do" )
	public String board_view(HttpServletRequest request, Model model) {
		System.out.println( "board_view() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );

		to = dao.boardView( to );

		model.addAttribute( "to", to );

		return "board_view1";
	}
	
	@RequestMapping( "/write.do" )
	public String board_write(HttpServletRequest request, Model model) {
		System.out.println( "board_write() 호출" );

		return "board_write1";
	}
	
	@RequestMapping( "/write_ok.do" )
	public String board_write_ok(HttpServletRequest request, Model model) {
		System.out.println( "board_write_ok() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSubject( request.getParameter( "subject" ) );
		to.setWriter( request.getParameter( "writer" ) );
		to.setMail( "" );
		if( !request.getParameter( "mail1" ).equals("") && !request.getParameter( "mail2" ).equals("") ) {
			to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );
		}
		to.setPassword( request.getParameter( "password" ) );
		to.setContent( request.getParameter( "content" ) );
		to.setWip( request.getRemoteAddr() );

		int flag = dao.boardWriteOk( to );
		
		model.addAttribute( "flag", flag );

		return "board_write1_ok";
	}
	
	@RequestMapping( "/modify.do" )
	public String board_modify(HttpServletRequest request, Model model) {
		System.out.println( "board_modify() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );

		to = dao.boardModify( to );
		
		model.addAttribute( "to", to );

		return "board_modify1";
	}
	
	@RequestMapping( "/modify_ok.do" )
	public String board_modify_ok(HttpServletRequest request, Model model) {
		System.out.println( "board_modify_ok() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setPassword( request.getParameter( "password" ) );

		to.setSubject( request.getParameter( "subject" ) );
		to.setMail( "" );
		if(!request.getParameter( "mail1" ).equals( "" ) && !request.getParameter( "mail2" ).equals( "" )) {
			to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );
		}

		to.setContent( request.getParameter( "content" ) );

		int flag = dao.boardModifyOk( to );
		
		model.addAttribute( "flag", flag );

		return "board_modify1_ok";
	}
	
	@RequestMapping( "/delete.do" )
	public String board_delete(HttpServletRequest request, Model model) {
		System.out.println( "board_delete() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );

		to = dao.boardDelete( to );
		
		model.addAttribute( "to", to );

		return "board_delete1";
	}
	
	@RequestMapping( "/delete_ok.do" )
	public String board_delete_ok(HttpServletRequest request, Model model) {
		System.out.println( "board_delete_ok() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setPassword( request.getParameter( "password" ) );

		int flag = dao.boardDeleteOk( to );

		model.addAttribute( "flag", flag );

		return "board_delete1_ok";
	}

}
