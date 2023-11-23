package com.exam.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
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
		/*
		DeptTO to = jdbcTemplate.queryForObject( "select deptno, dname, loc from dept where deptno=10", new BeanPropertyRowMapper<DeptTO>( DeptTO.class ) );
		*/
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
	
	// 다행 다열
	public void list3() {
		/*
		List<DeptTO> lists = jdbcTemplate.query( 
				"select deptno, dname, loc from dept", 
				new BeanPropertyRowMapper<DeptTO>( DeptTO.class ) 
		);
		*/
		/*
		List<DeptTO> lists = jdbcTemplate.query( 
				"select deptno, dname, loc from dept", 
				new DeptMapper() 
		);
		
		for( DeptTO to : lists ) {
			System.out.println( to.toString() );
		}
		*/
		/*
		List<EmpTO> lists = jdbcTemplate.query( 
				"select * from emp where deptno=? and job=?", 
				new BeanPropertyRowMapper<EmpTO>( EmpTO.class ), 
				"30", "SALESMAN" 
		);
		*/
		/*
		List<EmpTO> lists = jdbcTemplate.query( 
				"select * from emp where ename like ?", 
				new BeanPropertyRowMapper<EmpTO>( EmpTO.class ), 
				"S%" 
		);
		*/
		
		List<EmpTO> lists = jdbcTemplate.query( 
				new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						// TODO Auto-generated method stub
						String sql = "select * from emp where ename like ?";
						PreparedStatement pstmt = con.prepareStatement( sql );
						pstmt.setString( 1, "S%" );
						
						return pstmt;
					}
				}, new BeanPropertyRowMapper<EmpTO>(EmpTO.class ) 
		);
		
		for( EmpTO to : lists ) {
			System.out.println( to.toString() );
		}
	}
	
	public void dml() {
		// INSERT
		/*
		int result = jdbcTemplate.update( "insert into dept2 values ( 10, '연구부', '서울' )" );
		*/
		/*
		int result = jdbcTemplate.update( 
				"insert into dept2 values ( ?, ?, ? )", 
				"51", "생산부", "서울" 
		);
		*/
		
		int result = jdbcTemplate.update( 
				new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						// TODO Auto-generated method stub
						String sql = "insert into dept2 values( ?, ?, ? )";
						PreparedStatement pstmt = con.prepareStatement( sql );
						pstmt.setString( 1, "52" );
						pstmt.setString( 2, "개발부" );
						pstmt.setString( 3, "서울" );
						
						return pstmt;
					}
				}
		);
		
		System.out.println( "결과 : " + result );
	}
	
	public void ddl() {
		int result = jdbcTemplate.update( "create table tbl1 ( col1 varchar(10) )" );
		
		System.out.println( "결과 : " + result );
	}
	
}
