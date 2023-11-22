package com.exam.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.mvc.share.ShareClass;

@Controller
public class ConfigController {

	@Autowired
	private ShareClass shareClass;
	
	@RequestMapping( "/list1.do" )
	public String list1() {
		System.out.println( "ShareClass : " + shareClass );
		System.out.println( "ShareData1 : " + shareClass.getShareData1() );
		
		return "listview1";
	}
	
	@RequestMapping( "/list2.do" )
	public String list2() {
		System.out.println( "ShareClass : " + shareClass );
		System.out.println( "ShareData2 : " + shareClass.getShareData1() );
		
		return "listview2";
	}
}
