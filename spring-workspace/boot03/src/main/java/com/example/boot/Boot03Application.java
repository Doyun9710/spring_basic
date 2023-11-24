package com.example.boot;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot03Application implements CommandLineRunner {
	
	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(Boot03Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// 초기 실행 시 에러 -> 환경설정 미설정
		System.out.println( "Hello Spring Boot" );
		
		System.out.println( "dataSource : " + dataSource );
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BufferedReader br = null;

		try {
			// 연결
			conn = this.dataSource.getConnection();
			System.out.println( "연결 성공" );

			String sql = "select now() as now";
			pstmt = conn.prepareStatement( sql );
			
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				System.out.println( "현재시간 : " + rs.getString( "now" ) );
			}
		} catch (SQLException e) {
			System.out.println( "[에러] " + e.getMessage() );
		} catch (NumberFormatException e) {
			System.out.println( "[에러] " + e.getMessage() );
		}finally {
			if( br != null ) try { br.close(); } catch(IOException e) {}
			if( rs != null ) try { rs.close(); } catch(SQLException e) {}
			if( pstmt != null ) try { pstmt.close(); } catch(SQLException e) {}
			if( conn != null ) try { conn.close(); } catch(SQLException e) {}
		}
	}

}
