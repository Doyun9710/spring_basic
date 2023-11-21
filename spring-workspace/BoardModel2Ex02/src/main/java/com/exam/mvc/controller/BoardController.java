package com.exam.mvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exam.mvc.model.BoardDAO;
import com.exam.mvc.model.BoardTO;

@Controller
@RequestMapping( "/board" )
public class BoardController {
	
	// 새로운 Controller File 생성 시 ERROR
	// @RequestMapping( "/board" ) : URL 가상 디렉토리 생성 -> 참조 파일 위치 재조정

	// return String Type
	@RequestMapping( "/list.do" )
	public String board_list(HttpServletRequest request, Model model) {
		System.out.println( "board_list() 호출" );
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardTO> datas = dao.boardList();

		model.addAttribute( "datas", datas );
		
		return "board_list1";
	}
	
	@RequestMapping( "/view.do" )
	public String board_view(HttpServletRequest request, Model model) {
		System.out.println( "board_view() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardView( to );

		model.addAttribute( "to", to );

		return "board_view1";
	}
	
	@RequestMapping( "/write.do" )
	public String board_write(HttpServletRequest request, Model model) {
		System.out.println( "board_write() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardView( to );
		
		model.addAttribute( "to", to );

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
		
		
		BoardDAO dao = new BoardDAO();
		int flag = dao.boardWriteOk( to );
		
		model.addAttribute( "flag", flag );

		return "board_write1_ok";
	}
	
	@RequestMapping( "/modify.do" )
	public String board_modify(HttpServletRequest request, Model model) {
		System.out.println( "board_modify() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
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
		
		BoardDAO dao = new BoardDAO();
		int flag = dao.boardModifyOk( to );
		
		model.addAttribute( "flag", flag );

		return "board_modify1_ok";
	}
	
	@RequestMapping( "/delete.do" )
	public String board_delete(HttpServletRequest request, Model model) {
		System.out.println( "board_delete() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );

		BoardDAO dao = new BoardDAO();
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
		
		BoardDAO dao = new BoardDAO();
		int flag = dao.boardDeleteOk( to );

		model.addAttribute( "flag", flag );

		return "board_delete1_ok";
	}
	
	/*
	// return ModelAndView Type
	@RequestMapping( "/list.do" )
	public ModelAndView board_list(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( "ModelAndView board_list() 호출" );
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardTO> datas = dao.boardList();

		//request.setAttribute( "datas", datas );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_list1" );
		modelAndView.addObject( "datas", datas );
		
		//return new ModelAndView( "list1" );
		return modelAndView;
	}
	
	@RequestMapping( "/view.do" )
	public ModelAndView board_view(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( "ModelAndView board_view() 호출" );
		
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
	
	@RequestMapping( "/write.do" )
	public ModelAndView board_write(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( "ModelAndView board_write() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardView( to );
		
		//request.setAttribute( "to", to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_view1" );
		modelAndView.addObject( "to", to );
		
		return new ModelAndView( "board_write1" );
	}
	
	@RequestMapping( "/write_ok.do" )
	public ModelAndView board_write_ok(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( "ModelAndView board_write_ok() 호출" );
		
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
		
		
		BoardDAO dao = new BoardDAO();
		int flag = dao.boardWriteOk( to );
		
		//request.setAttribute( "flag", flag );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_write1_ok" );
		modelAndView.addObject( "flag", flag );
		
		return modelAndView;
	}
	
	@RequestMapping( "/modify.do" )
	public ModelAndView board_modify(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( "ModelAndView board_modify() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardModify( to );
		
		//request.setAttribute( "to", to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_modify1" );
		modelAndView.addObject( "to", to );
		
		return modelAndView;
	}
	
	@RequestMapping( "/modify_ok.do" )
	public ModelAndView board_modify_ok(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( "ModelAndView board_modify_ok() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setPassword( request.getParameter( "password" ) );

		to.setSubject( request.getParameter( "subject" ) );
		to.setMail( "" );
		if(!request.getParameter( "mail1" ).equals( "" ) && !request.getParameter( "mail2" ).equals( "" )) {
			to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );
		}

		to.setContent( request.getParameter( "content" ) );
		
		BoardDAO dao = new BoardDAO();
		int flag = dao.boardModifyOk( to );
		
		//request.setAttribute( "flag", flag );
		//request.setAttribute( "seq", to.getSeq() );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_modify1_ok" );
		modelAndView.addObject( "flag", flag );
		modelAndView.addObject( "seq", to.getSeq() );
		
		return modelAndView;
	}
	
	@RequestMapping( "/delete.do" )
	public ModelAndView board_delete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( "ModelAndView board_modify_ok() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );

		BoardDAO dao = new BoardDAO();
		to = dao.boardDelete( to );
		
		//request.setAttribute( "to", to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_delete1" );
		modelAndView.addObject( "to", to );
		
		return modelAndView;
	}
	
	@RequestMapping( "/delete_ok.do" )
	public ModelAndView board_delete_ok(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( "ModelAndView board_delete_ok() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setPassword( request.getParameter( "password" ) );
		
		BoardDAO dao = new BoardDAO();
		int flag = dao.boardDeleteOk( to );
		
		//request.setAttribute( "flag", flag );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_delete1_ok" );
		modelAndView.addObject( "flag", flag );
		
		return modelAndView;
	}
	*/
	
}
