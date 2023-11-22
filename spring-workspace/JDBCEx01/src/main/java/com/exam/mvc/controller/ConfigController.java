package com.exam.mvc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.mvc.model.JdbcDAO;

@Controller
public class ConfigController {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcDAO dao;
	
	
	@RequestMapping( "/list2.do" )
	public String list2() {
		
		//JdbcDAO dao = new JdbcDAO();
		System.out.println( dao.selectNow() );
		
		return "listview1";
	}
	
	@RequestMapping( "/list1.do" )
	public String list1() {
		
		//System.out.println( "dataSource : " + dataSource );
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "select now() as now";
			pstmt = conn.prepareStatement( sql );
			
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				System.out.println( rs.getString( "now" ) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}			
		}
		
		return "listview1";
	}
}






