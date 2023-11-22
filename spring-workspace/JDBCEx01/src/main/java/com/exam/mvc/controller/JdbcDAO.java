package com.exam.mvc.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDAO {
	
	@Autowired
	private DataSource dataSource;
	
	public String selectNow() {
		System.out.println( "dataSource : " + dataSource );
		return "now";
	}
}
