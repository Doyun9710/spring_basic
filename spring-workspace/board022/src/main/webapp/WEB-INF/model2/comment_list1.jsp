<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.example.model.BoardTO" %>
<%@ page import="com.example.model.CommentTO" %>
	
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>

<% 
	ArrayList<CommentTO> lists = (ArrayList)request.getAttribute( "commentLists" );
	
	JSONObject obj1 = new JSONObject();
	obj1.put( "flag", "0" );
	
	JSONArray arr1 = new JSONArray();
	for( CommentTO to : lists ) {
		JSONObject obj2 = new JSONObject();
		obj2.put( "seq", to.getSeq() );
		obj2.put( "writer", to.getWriter() );
		obj2.put( "content", to.getContent() );
		obj2.put( "wdate", to.getWdate() );
		
		arr1.add( obj2 );
	}
	
	obj1.put( "data", arr1 );
	
	out.println( obj1.toString() );
%>
