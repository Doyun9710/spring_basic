<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.example.model.BoardTO" %>

<%
	String cpage = (String)request.getAttribute( "cpage" );
	int flag = (Integer)request.getAttribute( "flag" );

	out.println( "<script type='text/javascript'>" );
	if( flag == 0 ) {
		out.println( "alert( '글수정 성공' )" );
		out.println( "location.href='./list.do?cpage=" + cpage + "';" );
	} else if( flag == 1 ) {
		out.println( "alert( '비밀번호 오류' )" );
		out.println( "history.back()" );
	} else if( flag == 2 ) {
		out.println( "alert( '시스템 에러' )" );
		out.println( "history.back()" );
	}
	out.println( "</script>" );
%>