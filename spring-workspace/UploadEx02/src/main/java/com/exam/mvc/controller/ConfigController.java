package com.exam.mvc.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import org.springframework.web.multipart.MultipartFile;
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
	public String form_ok(@RequestParam( "upload" ) MultipartFile multipartFile) {
		System.out.println( "form_ok() 호출" );
		
		System.out.println( multipartFile.getName() );
		System.out.println( multipartFile.getOriginalFilename() );
		System.out.println( multipartFile.getSize() );
		
		String uploadPath = "C:/Java/spring-workspace/UploadEx02/src/main/webapp/upload";
		
		FileRenamePolicy fileRenamePolicy = new FileRenamePolicy();
		String newFilename = fileRenamePolicy.renameFile( multipartFile.getOriginalFilename() );
		
		// 실제 파일 업로드
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream( uploadPath + "/" + newFilename );
			fos.write( multipartFile.getBytes() );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( fos != null ) try { fos.close(); } catch(IOException e) {}
		}
		
		return "form_ok";
	}
	
}
