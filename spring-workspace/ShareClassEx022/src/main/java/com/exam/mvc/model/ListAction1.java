package com.exam.mvc.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.exam.mvc.share.ShareClass;

public class ListAction1 implements Controller {

	private ShareClass shareClass;
	
	public void setShareClass( ShareClass shareClass ) {
		this.shareClass = shareClass;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println( "ListAction1 handleRequest() 호출" );
		
		return new ModelAndView( "listview1" ); // servlet-context viewname
	}

}
