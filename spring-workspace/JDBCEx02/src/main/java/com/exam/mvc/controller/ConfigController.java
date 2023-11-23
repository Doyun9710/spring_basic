package com.exam.mvc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.mvc.model.JdbcDAO;

@Controller
public class ConfigController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping( "/jdbc.do" )
	public String jdbc() {
		
		System.out.println( "jdbcTemplate : " + jdbcTemplate );
		
		// 데이터베이스 시간
		String result = jdbcTemplate.queryForObject( "select now() as now", String.class );
		
		System.out.println( "현재시간 : " + result );

		return "jdbc";
	}	

}






