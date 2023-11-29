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
	
	private String uploadPath = "C:/Java/spring-workspace/board022/src/main/webapp/upload";

	public BoardListTO boardList(BoardListTO listTO) {
		int cpage = listTO.getCpage();
		int recordPerPage = listTO.getRecordPerPage();
		int blockPerPage = listTO.getBlockPerPage();

		String sql = "select seq, subject, writer, filename, filesize, latitude, longitude, cmtcnt, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from img_board22 order by seq desc";
		ArrayList<BoardTO> datas = (ArrayList<BoardTO>) jdbcTemplate.query( 
				sql, 
				new BeanPropertyRowMapper<BoardTO>( BoardTO.class )
		);

		listTO.setTotalRecord( datas.size() );
		listTO.setTotalPage( ( ( listTO.getTotalRecord() - 1 ) / recordPerPage ) + 1);
		listTO.setStartBlock( cpage - ( cpage-1 ) % blockPerPage );
		listTO.setEndBlock( cpage - ( cpage-1 ) % blockPerPage + blockPerPage - 1 );
		if( listTO.getEndBlock() >= listTO.getTotalPage() ) {
			listTO.setEndBlock( listTO.getTotalPage() );
		}

		// SKIP - 각 페이지 별 게시글 자르기
		int skip = ( cpage - 1 ) * recordPerPage;
		datas.subList(0, skip).clear();
		datas.subList(listTO.getRecordPerPage(), datas.size()).clear();
		
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
		
		// [FIX] 이전글, 다음글
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
//			if( newfilename != null && oldfilename != null ) {
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
				seq 
		);

		return flag;
	}

}
