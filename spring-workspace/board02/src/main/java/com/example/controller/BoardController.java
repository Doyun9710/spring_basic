package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.BoardDAO;
import com.example.model.BoardListTO;
import com.example.model.BoardReplyTO;
import com.example.model.BoardTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO dao;

	@RequestMapping( "/list.do" )
	public String board_list(HttpServletRequest request, Model model) {
		System.out.println( "ListAction 호출" );
		
		int cpage = 1;
		if( request.getParameter( "cpage" ) != null
				&& !request.getParameter( "cpage" ).equals( "" ) ) {
			cpage = Integer.parseInt( request.getParameter( "cpage" ) );
		}

		BoardListTO listTO = new BoardListTO();
		listTO.setCpage( cpage );

		listTO = dao.boardList( listTO );
		model.addAttribute( "listTO", listTO );
		
		ArrayList<BoardTO> boardLists = listTO.getBoardLists();
		model.addAttribute( "boardLists", boardLists );
		
		return "board_list1";
	}
	
	@RequestMapping( "/view.do" )
	public String board_view(HttpServletRequest request, Model model) {
		System.out.println( "ViewAction 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		to = dao.boardView( to );
		model.addAttribute( "to", to );
		
		BoardReplyTO listRTO = new BoardReplyTO();
		listRTO.setSeq( request.getParameter( "seq" ) );
		listRTO = dao.boardReplyList( listRTO );
		
		ArrayList<BoardReplyTO> boardReplyLists = listRTO.getBoardReplyLists();
		model.addAttribute( "boardReplyLists", boardReplyLists );

		return "board_view1";
	}
	
	@RequestMapping( "/write.do" )
	public String board_write(HttpServletRequest request, Model model) {
		System.out.println( "board_write() 호출" );

		return "board_write1";
	}
	
	@RequestMapping( "/write_ok.do" )
	public String board_write_ok( @RequestParam( "upload" ) MultipartFile upload, HttpServletRequest request, Model model ) {
		System.out.println( "WriteOkAction 호출" );

		String uploadPath = "C:/Java/spring-workspace/board02/src/main/webapp/upload";
		int maxFileSize = 2 * 1024 * 1024;
		String encType = "utf-8";
		
		// +++ 중복 파일 이름 변경
		try {
			if( !upload.isEmpty() )
				upload.transferTo( new File( uploadPath, upload.getOriginalFilename() ) );
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

		to.setFilename( upload.getOriginalFilename() );
		to.setFilesize( 0 );
		if( upload != null ) {
			to.setFilesize( upload.getSize() );
		}
		
		to.setLatitude( request.getParameter( "latitude" ) );
		to.setLongitude( request.getParameter( "longitude" ) );

		int flag = dao.boardWriteOk( to );
		
		model.addAttribute( "flag", flag );

		return "board_write1_ok";
	}
	
	@RequestMapping( "/modify.do" )
	public String board_modify(HttpServletRequest request, Model model) {
		System.out.println( "ModifyAction 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		to = dao.boardModify( to );

		model.addAttribute( "to", to );

		return "board_modify1";
	}
	
	@RequestMapping( "/modify_ok.do" )
	public String board_modify_ok(@RequestParam( "upload" ) MultipartFile upload, HttpServletRequest request, Model model) {
		System.out.println( "ModifyOkAction 호출" );
		
		String uploadPath = "C:/Java/spring-workspace/board02/src/main/webapp/upload";
		int maxFileSize = 2 * 1024 * 1024;
		String encType = "utf-8";
		
		// +++ 중복 파일 이름 변경
		try {
			if( !upload.isEmpty() )
				upload.transferTo( new File( uploadPath, upload.getOriginalFilename() ) );
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String cpage = request.getParameter( "cpage" );

		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setPassword( request.getParameter( "password" ) );

		to.setSubject( request.getParameter( "subject" ) );
		to.setMail( "" );
		if(!request.getParameter( "mail1" ).equals( "" ) && !request.getParameter( "mail2" ).equals( "" )) {
			to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );
		}

		to.setContent( request.getParameter( "content" ) );

		//String oldfilename = multi.getParameter( "filename_org" );
		if( !upload.isEmpty() ) to.setFilename( upload.getOriginalFilename() );
		else to.setFilename( "" );
		to.setFilesize( 0 );
		if( !upload.isEmpty() ) {
			to.setFilesize( upload.getSize() );
		}
		
		to.setLatitude( request.getParameter( "latitude" ) );
		to.setLongitude( request.getParameter( "longitude" ) );

		int flag = dao.boardModifyOk( to );
		
		model.addAttribute( "flag", flag );
		model.addAttribute( "cpage", cpage );

		return "board_modify1_ok";
	}
	
	@RequestMapping( "/delete.do" )
	public String board_delete(HttpServletRequest request, Model model) {
		System.out.println( "DeleteAction 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );

		to = dao.boardDelete( to );
		
		model.addAttribute( "to", to );

		return "board_delete1";
	}
	
	@RequestMapping( "/delete_ok.do" )
	public String board_delete_ok(HttpServletRequest request, Model model) {
		System.out.println( "DeleteOkAction 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setPassword( request.getParameter( "password" ) );
		
		int flag = dao.boardDeleteOk( to );

		model.addAttribute( "flag", flag );

		return "board_delete1_ok";
	}
	
	/*
	// return ModelAndView Type
	@RequestMapping( "/list.do" )
	public ModelAndView list() {
		
		ArrayList<BoardTO> datas = dao.boardList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_list1" );
		modelAndView.addObject( "datas", datas );
	
		return modelAndView;
	}
	
	@RequestMapping( "/view.do" )
	public ModelAndView board_view(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( "ModelAndView board_view() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );

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

		int flag = dao.boardDeleteOk( to );
		
		//request.setAttribute( "flag", flag );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_delete1_ok" );
		modelAndView.addObject( "flag", flag );
		
		return modelAndView;
	}
	*/

}