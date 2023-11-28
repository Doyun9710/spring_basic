package com.example.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ConfigController {

	@RequestMapping( "/form.do" )
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println( "form() 호출" );

		return new ModelAndView( "form" );
	}

	@RequestMapping( "/form_ok.do" )
	public ModelAndView form_ok(
			@RequestParam( "upload" ) MultipartFile upload, 
			HttpServletRequest request 
			) {
		
		System.out.println( "form_ok() 호출" );
		
		try {
			if( !upload.isEmpty() ) {
				// Check
				System.out.println( upload.getOriginalFilename() );
				System.out.println( upload.getName() );
				System.out.println( upload.getSize() );
				
				System.out.println( System.getProperty( "java.io.tmpdir" ) );
				System.out.println( request.getParameter( "data" ) );
				/*
				String filename = upload.getOriginalFilename().substring(0, upload.getOriginalFilename().lastIndexOf( "." ) );
				String extension = upload.getOriginalFilename().substring( upload.getOriginalFilename().lastIndexOf( "." ) );
				System.out.println( "filename : " + filename );
				System.out.println( "extension : " + extension );
				*/
				FileRenamePolicy fileRenamePolicy = new FileRenamePolicy();
				String newFilename = fileRenamePolicy.renameFile( upload.getOriginalFilename() );
				
				// 실제 경로로 이동. 폴더 미생성 시 에러
				//upload.transferTo( new File( "c:/java/upload", upload.getOriginalFilename() ) );
				if( newFilename.split( "\\." )[1].equals( "jpg" ) || newFilename.split( "\\." )[1].equals( "png" ) ) {
					upload.transferTo( new File( "c:/java/images", newFilename ) );
				} else {
					upload.transferTo( new File( "c:/java/uploads", newFilename ) );
				}
				
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return new ModelAndView( "form_ok" );
	}
	
}
