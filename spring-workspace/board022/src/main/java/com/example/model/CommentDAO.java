package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 댓글 불러오기 view.do(board_view.jsp)
	public ArrayList<CommentTO> boardCommentList(CommentTO cto) {
		ArrayList<CommentTO> boardReplyLists = (ArrayList<CommentTO>) jdbcTemplate.query( 
				"select writer, content, date_format(wdate, '%Y-%m-%d') wdate from rep_board22 where pseq=? order by seq desc", 
				new BeanPropertyRowMapper<CommentTO>( CommentTO.class ), 
				cto.getPseq() 
		);
		return boardReplyLists;
	}
	
	// 댓글 추가 rep_board22
	public int boardCommentWriteOk(CommentTO cto) {
		int result = jdbcTemplate.update( 
				"insert into rep_board22 values ( 0, ?, ?, ?, ?, now() )", 
				cto.getPseq(), cto.getWriter(), cto.getPassword(), cto.getContent() 
		);
		
		result = jdbcTemplate.update( 
				"update img_board22 set cmtcnt=cmtcnt+1 where seq=?", 
				cto.getPseq() 
		);
		
		int flag = 2;
		if( result == 0 ) {
			flag = 1;
		} else if( result == 1 ) {
			flag = 0;
		}

		return flag;
	}
	
	public int boardCommentDeleteOk(CommentTO cto) {
		int result = jdbcTemplate.update( 
				"delete from rep_board22 where pseq=?", 
				cto.getPseq() 
		);

		return 0;
	}
	
}
