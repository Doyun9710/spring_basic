package com.exam.mvc.controller;

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

import com.exam.mvc.model.ZipcodeDAO;
import com.exam.mvc.model.ZipcodeTO;

@Controller
public class ConfigController {
	
	@RequestMapping( "/zipcode.do" )
	public String form_zipcode() {
		System.out.println( "form_zipcode() 호출" );
		
		return "zipcode";
	}
	/*
	@RequestMapping( "/zipcode_ok.do" )
	public ModelAndView form_zipcode_ok(@RequestParam( "strdong" ) String strDong, Model model) {
		System.out.println( "ModelAndView form_zipcode_ok() 호출 : " + strDong );
		
		ZipcodeDAO dao = new ZipcodeDAO();
		ArrayList<ZipcodeTO> lists = dao.listZipcode(strDong);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "zipcode_ok" );
		modelAndView.addObject( "lists", lists );
		
		return modelAndView;
	}
	*/
	@RequestMapping( "/zipcode_ok.do" )
	public String form_zipcode_ok(@RequestParam( "strdong" ) String strDong, Model model) {
		System.out.println( "ModelAndView form_zipcode_ok() 호출 : " + strDong );
		
		ZipcodeDAO dao = new ZipcodeDAO();
		ArrayList<ZipcodeTO> lists = dao.listZipcode(strDong);

		model.addAttribute( "lists", lists );
		
		return "zipcode_ok";
	}
	
}
