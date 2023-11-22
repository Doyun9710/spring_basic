package com.exam.mvc.controller;

import java.io.IOException;
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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class ConfigController {

	@RequestMapping( "/form.do" )
	public String form(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( "form() 호출" );

		return "form";
	}
	
	// C:/Java/spring-workspace/UploadEx01/src/main/webapp/upload
	
	@RequestMapping( "/form_ok.do" )
	public String form_ok(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( "form_ok() 호출" );
		
		String uploadPath = "C:/Java/spring-workspace/UploadEx01/src/main/webapp/upload";
		int maxFileSize = 1024 * 1024 * 2;
		String encType = "utf-8";
		
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest( request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy() );
			
			System.out.println( multi.getOriginalFileName( "upload" ) );
			System.out.println( multi.getFilesystemName( "upload" ) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "form_ok";
	}
	
}
