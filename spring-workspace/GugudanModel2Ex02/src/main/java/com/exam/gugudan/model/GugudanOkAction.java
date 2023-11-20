package com.exam.gugudan.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class GugudanOkAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "GugudanOkAction handleRequest() 호출" );
		
		return new ModelAndView( "gugudan_ok" );
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println( "GugudanOkAction 호출" );
		
		String startDan = request.getParameter( "startdan" );
		String endDan = request.getParameter( "enddan" );
		
		int iStartDan = Integer.parseInt( startDan );
		int iEndDan = Integer.parseInt( endDan );
		
		StringBuilder sbHtml = new StringBuilder();
		sbHtml.append( "<table border='1' width='800'>" );
		for( int i=iStartDan ; i<=iEndDan ; i++ ) {
			sbHtml.append( "<tr>" );
			for( int j=1 ; j<=9 ; j++) {
				sbHtml.append( "<td>" + i + "X" + j + "=" + (i*j) + "</td>" );
			}
			sbHtml.append( "</tr>" );
		}
		sbHtml.append( "</table>" );
		
		request.setAttribute( "result", sbHtml.toString() );
	}
}
