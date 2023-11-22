package com.exam.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.mvc.model.BoardDAO;
import com.exam.mvc.model.BoardTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class BoardController {
	private String uploadPath = "C:/Java/spring-workspace/PDSBoardEx01/src/main/webapp/upload";
	private int maxFileSize = 1024 * 1024 * 2;
	private String encType = "utf-8";

	@RequestMapping( "/list.do" )
	public String list(HttpServletRequest request, Model model ) {
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardTO> lists = dao.boardList();
		
		model.addAttribute( "lists", lists );
		
		return "board_list1";
	}
	
	@RequestMapping( "/write.do" )
	public String write(HttpServletRequest request, Model model ) {
		
		return "board_write1";
	}
	
	@RequestMapping( "/write_ok.do" )
	public String write_ok(HttpServletRequest request, Model model ) {
		
		try {
			MultipartRequest multi
			= new MultipartRequest( request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy() );
			
			BoardTO to = new BoardTO();
			
			to.setSubject( multi.getParameter( "subject" ) );
			to.setWriter( multi.getParameter( "writer" ) );
			to.setMail( "" ); 
			if( !multi.getParameter( "mail1" ).equals("") 
					&& !multi.getParameter( "mail2" ).equals("") ) {
				to.setMail( multi.getParameter( "mail1" ) + "@" + multi.getParameter( "mail2" ) );
			}
					
			to.setPassword( multi.getParameter( "password" ) );
			to.setContent( multi.getParameter( "content" ) );
			
			to.setWip( request.getRemoteAddr() );
			
			to.setFilename( multi.getFilesystemName( "upload" ) );
			to.setFilesize( 0 );
			if( multi.getFile( "upload") != null ) {
				to.setFilesize( multi.getFile( "upload" ).length() );
			}
			
			BoardDAO dao = new BoardDAO();
			int flag = dao.boardWriteOk( to );
			
			model.addAttribute( "flag", flag );

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		}

		return "board_write1_ok";
	}
	
	@RequestMapping( "/view.do" )
	public String view(HttpServletRequest request, Model model ) {
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardView( to );
		
		model.addAttribute( "to", to );
		
		return "board_view1";
	}

	@RequestMapping( "/modify.do" )
	public String modify(HttpServletRequest request, Model model ) {
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardModify( to );

		model.addAttribute( "to", to );
		
		return "board_modify1";
	}

	@RequestMapping( "/modify_ok.do" )
	public String modify_ok(HttpServletRequest request, Model model ) {
		
		try {
			/*
			String uploadPath = "C:/Java/spring-workspace/PDSBoardEx01/src/main/webapp/upload";
			int maxFileSize = 2 * 1024 * 1024;
			String encType = "utf-8";
			*/
			MultipartRequest multi
			= new MultipartRequest( request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy() );
			
			BoardTO to = new BoardTO();
			to.setSeq( multi.getParameter( "seq" ) );
			to.setSubject( multi.getParameter( "subject" ) );
			to.setMail( "" ); 
			if( !multi.getParameter( "mail1" ).equals("") 
					&& !multi.getParameter( "mail2" ).equals("") ) {
				to.setMail( multi.getParameter( "mail1" ) + "@" + multi.getParameter( "mail2" ) );
			}
					
			to.setPassword( multi.getParameter( "password" ) );
			to.setContent( multi.getParameter( "content" ) );
			
			to.setFilename( multi.getFilesystemName( "upload" ) );
			to.setFilesize( 0 );
			if( multi.getFile( "upload") != null ) {
				to.setFilesize( multi.getFile( "upload" ).length() );
			}
			
			BoardDAO dao = new BoardDAO();
			int flag = dao.boardModifyOk( to );
			
			model.addAttribute( "flag", flag );
			model.addAttribute( "seq", to.getSeq() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "board_modify1_ok";
	}

	@RequestMapping( "/delete.do" )
	public String delete(HttpServletRequest request, Model model ) {
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardDelete( to );
		
		model.addAttribute( "to", to );
		
		return "board_delete1";
	}

	@RequestMapping( "/delete_ok.do" )
	public String delete_ok(HttpServletRequest request, Model model ) {
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setPassword( request.getParameter( "password" ) );
		
		BoardDAO dao = new BoardDAO();
		int flag = dao.boardDeleteOk( to );
		
		model.addAttribute( "flag", flag );
		
		return "board_delete1_ok";
	}
	
	@RequestMapping( "/download.do" )
	public String download(HttpServletRequest request, Model model ) {
		
		String filename = request.getParameter( "filename" );
		
		model.addAttribute( "filename", filename );
		
		return "download";
	}
}
