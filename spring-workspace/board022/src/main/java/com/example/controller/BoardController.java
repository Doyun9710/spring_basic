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
import org.springframework.web.servlet.ModelAndView;

import com.example.model.BoardDAO;
import com.example.model.BoardListTO;
import com.example.model.BoardTO;
import com.example.model.CommentDAO;
import com.example.model.CommentTO;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	@Autowired
	private CommentDAO commentdao;

	@RequestMapping( "/list.do" )
	public ModelAndView board_list(HttpServletRequest request, Model model) {
		int cpage = 1;
		if( request.getParameter( "cpage" ) != null && !request.getParameter( "cpage" ).equals( "" ) ) {
			cpage = Integer.parseInt( request.getParameter( "cpage" ) );
		}

		BoardListTO listTO = new BoardListTO();
		listTO.setCpage( cpage );
		listTO = dao.boardList( listTO );
		//ArrayList<BoardTO> boardLists = listTO.getBoardLists();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_list1" );
		model.addAttribute( "listTO", listTO );
		//model.addAttribute( "boardLists", boardLists );
		
		return modelAndView;
	}
	
	@RequestMapping( "/view.do" )
	public ModelAndView board_view(HttpServletRequest request, Model model) {
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to = dao.boardView( to );
		
		CommentTO listRTO = new CommentTO();
		listRTO.setSeq( request.getParameter( "seq" ) );
		listRTO = commentdao.boardReplyList( listRTO );
		ArrayList<CommentTO> boardReplyLists = listRTO.getBoardReplyLists();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_view1" );
		model.addAttribute( "to", to );
		model.addAttribute( "boardReplyLists", boardReplyLists );

		return modelAndView;
	}
	
	@RequestMapping( "/write.do" )
	public ModelAndView write(HttpServletRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_write1" );

		return modelAndView;
	}
	
	@RequestMapping( "/write_ok.do" )
	public ModelAndView board_write_ok(@RequestParam( "upload" ) MultipartFile upload, HttpServletRequest request, Model model) {
		String uploadPath = "C:/Java/spring-workspace/board022/src/main/webapp/upload";
		int maxFileSize = 2 * 1024 * 1024;
		String encType = "utf-8";
		
		// Avoid file name duplication
		FileRenamePolicy fileRenamePolicy = new FileRenamePolicy();
		String newFilename = fileRenamePolicy.renameFile( upload.getOriginalFilename() );
		try {
			if( !upload.isEmpty() )
				upload.transferTo( new File( uploadPath, newFilename ) );
		} catch (IllegalStateException | IOException e) {
			System.out.println( "[에러] Controller-write_ok | 파일 이름 중복 방지" );
			e.printStackTrace();
		}
		
		BoardTO to = new BoardTO();
		to.setSubject( request.getParameter( "subject" ) );
		to.setWriter( request.getParameter( "writer" ) );
		to.setMail( "" );
		if( !request.getParameter( "mail1" ).equals( "" ) && !request.getParameter( "mail2" ).equals( "" ) )
			to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );
		to.setPassword( request.getParameter( "password" ) );
		to.setContent( request.getParameter( "content" ) );
		to.setWip( request.getRemoteAddr() );
		to.setFilename( newFilename );
		to.setFilesize( 0 );
		if( !upload.isEmpty() )
			to.setFilesize( upload.getSize() );
		to.setLatitude( request.getParameter( "latitude" ) );
		to.setLongitude( request.getParameter( "longitude" ) );

		int flag = dao.boardWriteOk( to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_write1_ok" );
		model.addAttribute( "flag", flag );

		return modelAndView;
	}
	
	@RequestMapping( "/modify.do" )
	public ModelAndView board_modify(HttpServletRequest request, Model model) {
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		to = dao.boardModify( to );

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_modify1" );
		model.addAttribute( "to", to );

		return modelAndView;
	}
	
	@RequestMapping( "/modify_ok.do" )
	public ModelAndView board_modify_ok(@RequestParam( "upload" ) MultipartFile upload, HttpServletRequest request, Model model) {
		String uploadPath = "C:/Java/spring-workspace/board022/src/main/webapp/upload";
		int maxFileSize = 2 * 1024 * 1024;
		String encType = "utf-8";
		
		// Avoid file name duplication
		FileRenamePolicy fileRenamePolicy = new FileRenamePolicy();
		String newFilename = fileRenamePolicy.renameFile( upload.getOriginalFilename() );
		try {
			if( !upload.isEmpty() )
				upload.transferTo( new File( uploadPath, newFilename ) );
		} catch (IllegalStateException | IOException e) {
			System.out.println( "[에러] Controller-write_ok | 파일 이름 중복 방지" );
			e.printStackTrace();
		}

		String cpage = request.getParameter( "cpage" );

		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setPassword( request.getParameter( "password" ) );
		to.setSubject( request.getParameter( "subject" ) );
		to.setMail( "" );
		if( !request.getParameter( "mail1" ).equals( "" ) && !request.getParameter( "mail2" ).equals( "" ) )
			to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );
		to.setContent( request.getParameter( "content" ) );
//		String oldfilename = request.getParameter( "filename_org" );
		if( !upload.isEmpty() ) to.setFilename( newFilename );
		else to.setFilename( "" );
		to.setFilesize( 0 );
		if( !upload.isEmpty() ) to.setFilesize( upload.getSize() );
		to.setLatitude( request.getParameter( "latitude" ) );
		to.setLongitude( request.getParameter( "longitude" ) );

		int flag = dao.boardModifyOk( to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_modify1_ok" );
		model.addAttribute( "flag", flag );
		model.addAttribute( "cpage", cpage );

		return modelAndView;
	}
	
	@RequestMapping( "/delete.do" )
	public ModelAndView board_delete(HttpServletRequest request, Model model) {
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to = dao.boardDelete( to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_delete1" );
		model.addAttribute( "to", to );

		return modelAndView;
	}
	
	@RequestMapping( "/delete_ok.do" )
	public ModelAndView board_delete_ok(HttpServletRequest request, Model model) {
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setPassword( request.getParameter( "password" ) );
		
		int flag = dao.boardDeleteOk( to );

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_delete1_ok" );
		model.addAttribute( "flag", flag );

		return modelAndView;
	}
	
}