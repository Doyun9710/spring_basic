package com.example.model;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String uploadPath = "C:/Java/spring-workspace/board02/src/main/webapp/upload";

	public BoardListTO boardList(BoardListTO listTO) {
		// paging
		int cpage = listTO.getCpage();
		int recordPerPage = listTO.getRecordPerPage();
		int blockPerPage = listTO.getBlockPerPage();

		//String sql = "select seq, subject, writer, filename, filesize, latitude, longitude, cmtcnt, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from img_board22 order by seq desc limit ?, 5";
		ArrayList<BoardTO> datas = (ArrayList<BoardTO>) jdbcTemplate.query( 
				"select seq from img_board22", 
				new BeanPropertyRowMapper<BoardTO>( BoardTO.class )
		);

		listTO.setTotalRecord( datas.size() );
		listTO.setTotalPage( ( ( listTO.getTotalRecord() - 1 ) / recordPerPage ) + 1);

		listTO.setStartBlock( cpage - ( cpage-1 ) % blockPerPage );
		listTO.setEndBlock( cpage - ( cpage-1 ) % blockPerPage + blockPerPage - 1 );
		
		if( listTO.getEndBlock() >= listTO.getTotalPage() ) {
			listTO.setEndBlock( listTO.getTotalPage() );
		}

		int skip = ( cpage - 1 ) * recordPerPage;
		String sql = "select seq, subject, writer, filename, filesize, latitude, longitude, cmtcnt, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from img_board22 order by seq desc limit ?, ?";
		datas = (ArrayList<BoardTO>) jdbcTemplate.query( 
				sql, 
				new BeanPropertyRowMapper<BoardTO>( BoardTO.class ), 
				skip, listTO.getRecordPerPage() 
		);

		listTO.setBoardLists( datas );
		
		return listTO;
	}
	
	public BoardTO boardView(BoardTO to) {
		String seq = to.getSeq();
		String nextseq = null; String nextsubject = null;
		String beseq = null; String besubject = null;
		
		int result = jdbcTemplate.update( 
				"update img_board22 set hit=hit+1 where seq=?", 
				to.getSeq() 
		);
		
		// 이전글, 다음글
		try {
			to = jdbcTemplate.queryForObject( 
					"select seq, subject from img_board22 where seq > ? order by seq asc limit 1", 
					new BeanPropertyRowMapper<BoardTO>( BoardTO.class ), 
					seq
			);
			nextseq = to.getSeq(); nextsubject = to.getSubject();
        } catch (EmptyResultDataAccessException e) {
            nextseq = seq; nextsubject = "글이 없습니다.";
        }
		try {
			to = jdbcTemplate.queryForObject( 
					"select seq, subject from img_board22 where seq < ? order by seq desc limit 1", 
					new BeanPropertyRowMapper<BoardTO>( BoardTO.class ), 
					seq
			);
			beseq = to.getSeq(); besubject = to.getSubject();
        } catch (EmptyResultDataAccessException e) {
        	beseq = seq; besubject = "글이 없습니다.";
        }

		to = jdbcTemplate.queryForObject( 
				"select seq, subject, writer, mail, wip, wdate, hit, content, filename, filesize, latitude, longitude from img_board22 where seq=?", 
				new BeanPropertyRowMapper<BoardTO>( BoardTO.class ), 
				seq  
		);
		to.setContent( to.getContent() == null ? "" : to.getContent().replaceAll("\n", "<br />") );
		
		if( to.getFilename() != null ) to.setFilename( to.getFilename() );
		else to.setFilename( "없음" );
		to.setFilesize( to.getFilesize() / 1024 );
		
		to.setNextseq(nextseq); to.setNextsub(nextsubject);
		to.setBeseq(beseq); to.setBesub(besubject);
		
		return to;
	}

	public void boardWrite() {}
	
	public int boardWriteOk(BoardTO to) {

		int result = jdbcTemplate.update( 
				"insert into img_board22 values ( 0, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0, ?, now() )", 
				to.getSubject(), to.getWriter(), to.getMail(), to.getPassword(), to.getContent(), 
				to.getFilename(), to.getFilesize(), to.getLatitude(), to.getLongitude(), to.getWip() 
		);
		
		String curseq = jdbcTemplate.queryForObject( 
				"select seq from img_board22 order by seq desc limit 1", 
				String.class, 
				to.getSeq() 
		);
		
		result = jdbcTemplate.update( 
				"insert into rep_board22 values ( 0, ?, 0, 0, 0, now() )", 
				curseq 
		);

		int flag = 2;
		if( result == 0 ) {
			flag = 1;
		} else if( result == 1 ) {
			flag = 0;
		}

		return flag;
	}
	
	public BoardTO boardModify(BoardTO to) {
		to = jdbcTemplate.queryForObject( 
				"select seq, subject, writer, mail, content, filename, latitude, longitude from img_board22 where seq=?", 
				new BeanPropertyRowMapper<BoardTO>( BoardTO.class ), 
				to.getSeq() 
		);

		return to;
	}
	
	public int boardModifyOk(BoardTO to) {
		String oldfilename = jdbcTemplate.queryForObject( 
				"select filename from img_board22 where seq=?", 
				String.class, 
				to.getSeq() 
		);
		
		int result = 0;
		if( !to.getFilename().equals( "" ) ) {
			result = jdbcTemplate.update( 
					"update img_board22 set subject=?, mail=?, content=?, filename=?, filesize=?, latitude=?, longitude=? where seq=? and password=?", 
					to.getSubject(), to.getMail(), to.getContent(), to.getFilename(), to.getFilesize(), 
					to.getLatitude(), to.getLongitude(), to.getSeq(), to.getPassword() 
			);
		} else {
			result = jdbcTemplate.update( 
					"update img_board22 set subject=?, mail=?, content=? where seq=? and password=?", 
					to.getSubject(), to.getMail(), to.getContent(), to.getSeq(), to.getPassword() 
			);
		}
		
		int flag = 2;
		if( result == 0 ) {
			flag = 1;
			
			// 잘못 업로드 된 파일 삭제
			if( to.getFilename() != null ) {
				File file = new File( uploadPath, to.getFilename() );
				file.delete();
			}
		} else if( result == 1 ) {
			flag = 0;
			
			// 구형 파일 존재 시 삭제
			//if( newfilename != null && oldfilename != null ) {
			if( !to.getFilename().equals( "" ) ) {
				File file = new File( uploadPath, oldfilename );
				file.delete();
			}
		}

		return flag;
	}
	
	public BoardTO boardDelete(BoardTO to) {
		to = jdbcTemplate.queryForObject( 
				"select seq, subject, writer from img_board22 where seq=?", 
				new BeanPropertyRowMapper<BoardTO>( BoardTO.class ), 
				to.getSeq() 
		);

		return to;
	}
	
	public int boardDeleteOk(BoardTO to) {
		String seq = to.getSeq();
		String password = to.getPassword();
		
		to = jdbcTemplate.queryForObject( 
				"select filename from img_board22 where seq=?", 
				new BeanPropertyRowMapper<BoardTO>( BoardTO.class ), 
				to.getSeq() 
		);

		int result = jdbcTemplate.update( 
				"delete from img_board22 where seq=? and password=?", 
				seq, password 
		);

		int flag = 2;
		if( result == 0 ) {
			flag = 1;
		} else if( result == 1 ) {
			flag = 0;

			// 실제 파일 삭제
			if( !to.getFilename().equals( "" ) ) {
				File file = new File( uploadPath, to.getFilename() );
				file.delete();
			}
		}
		
		result = jdbcTemplate.update( 
				"delete from rep_board22 where pseq=?", 
				to.getSeq() 
		);

		return flag;
	}
/*
	// 댓글 추가 rep_board22 INSERT
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
	// 댓글 불러오기 -> view.do(board_view.jsp)
	public BoardReplyTO boardReplyList(BoardReplyTO listRTO) {
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

			ArrayList<BoardReplyTO> boardReplyLists = new ArrayList<BoardReplyTO>();
			while( rs.next() ) {
				BoardReplyTO rto = new BoardReplyTO();
				
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
