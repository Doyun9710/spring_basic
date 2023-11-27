package com.example.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDAO {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void select() {
		
		System.out.println( "dataSource : " + dataSource );
		System.out.println( "jdbcTemplate : " + jdbcTemplate );
		
		String result = jdbcTemplate.queryForObject( 
				"select now() as now", String.class );
		System.out.println( "result : " + result );
		
	}
}
