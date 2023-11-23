package com.exam.mvc.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 1행 1열
	public void list1() {
		// 데이터베이스 시간
		String result = jdbcTemplate.queryForObject( "select now() as now", String.class );
		
		System.out.println( "JdbcDAO list1() 현재시간 : " + result );
	}
	
	// 1행 다열
	public void list2() {
		//DeptTO to = jdbcTemplate.queryForObject( "select deptno, dname, loc from dept where deptno=10", new BeanPropertyRowMapper<DeptTO>( DeptTO.class ) );
		/*
		DeptTO to = jdbcTemplate.queryForObject( 
				"select deptno, dname, loc from dept where deptno=?", 
				new BeanPropertyRowMapper<DeptTO>( DeptTO.class ), 
				"20" 
		);
		*/
		/*
		// 자동 Setter
		DeptTO to = jdbcTemplate.queryForObject( 
				"select deptno, dname, loc from dept where deptno=?", 
				new Object[] { "30" }, 
				new BeanPropertyRowMapper<DeptTO>( DeptTO.class ) 
		);
		*/
		// 수동 Setter
		DeptTO to = jdbcTemplate.queryForObject( 
				"select deptno, dname, loc from dept where deptno=?", 
				new Object[] { "30" }, 
				new DeptMapper()
		);
		
		System.out.println( to.toString() );
	}
	
}
