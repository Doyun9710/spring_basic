package com.exam.mvc.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void list1() {
		// 데이터베이스 시간
		String result = jdbcTemplate.queryForObject( "select now() as now", String.class );
		
		System.out.println( "JdbcDAO list1() 현재시간 : " + result );
	}
}
