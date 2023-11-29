package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/*
	// [FIX] 댓글 추가 rep_board22 INSERT
		public int boardReplyOk(BoardReplyTO rto) {
			// TODO Auto-generated method stub
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			int flag = 1;
			
			try {
				conn = dataSource.getConnection();

				// INSERT
				String sql = "insert into rep_board22 values ( 0, ?, ?, ?, ?, now() )";
				pstmt = conn.prepareStatement( sql );
				pstmt.setString( 1, rto.getSeq() );
				pstmt.setString( 2, rto.getCwriter() );
				pstmt.setString( 3, rto.getCpassword() );
				pstmt.setString( 4, rto.getCcontent() );

				if( pstmt.executeUpdate() == 1 ) {
					flag = 0;
				}
				
				
				sql = "update img_board22 set cmtcnt=cmtcnt+1 where seq=?";
				pstmt = conn.prepareStatement( sql );
				pstmt.setString( 1, rto.getSeq() );
				
				pstmt.executeUpdate();
			} catch(SQLException e) {
				System.out.println( "[에러] + " + e.getMessage() );
			} finally {
				if( rs != null ) try { rs.close(); } catch(SQLException e) {}
				if( pstmt != null ) try { pstmt.close(); } catch(SQLException e) {}
				if( conn != null ) try { conn.close(); } catch(SQLException e) {}
			}

			return flag;
		}
	*/
		// [FIX] 댓글 불러오기 -> view.do(board_view.jsp)
		public CommentTO boardReplyList(CommentTO listRTO) {
			// TODO Auto-generated method stub
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = this.dataSource.getConnection();

				String sql = "select writer, content, date_format(wdate, '%Y-%m-%d') wdate from rep_board22 where pseq=? order by seq desc";
				pstmt = conn.prepareStatement( sql );
				pstmt.setString( 1, listRTO.getSeq() );
				rs = pstmt.executeQuery();

				ArrayList<CommentTO> boardReplyLists = new ArrayList<CommentTO>();
				while( rs.next() ) {
					CommentTO rto = new CommentTO();
					
					rto.setCwriter( rs.getString( "writer" ) );
					rto.setCcontent( rs.getString( "content" ) );
					rto.setCdate( rs.getString( "wdate" ) );
					
					boardReplyLists.add( rto );
				}
				
				listRTO.setBoardReplyLists( boardReplyLists );
			} catch( SQLException e ) {
				System.out.println( "[에러] " + e.getMessage() );
			} finally {
				if( rs != null ) try { rs.close(); } catch(SQLException e) {}
				if( pstmt != null ) try { pstmt.close(); } catch(SQLException e) {}
				if( conn != null ) try { conn.close(); } catch(SQLException e) {}
			}

			return listRTO;
		}
	
}
