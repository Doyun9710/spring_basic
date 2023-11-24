package com.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void select2() {
		String result = jdbcTemplate.queryForObject(
				"select now() as now", 
				String.class 
		);
		
		System.out.println( "현재시간 : " + result );
	}
}
