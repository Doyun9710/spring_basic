package com.example.boot;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Boot2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// 선언 & 설정
		String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "!123456";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BufferedReader br = null;

		int inputDeptno = 20;
		
		try {
			// 로딩
			Class.forName( "org.mariadb.jdbc.Driver" );
			System.out.println( "드라이버 로딩 성공" );
			
			// 연결
			conn = DriverManager.getConnection(url, user, password);
			System.out.println( "연결 성공" );

			String sql = "select now() as now";
			pstmt = conn.prepareStatement( sql );
			
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				System.out.println( "현재시간 : " + rs.getString( "now" ) );
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println( "[에러] " + e.getMessage() );
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
