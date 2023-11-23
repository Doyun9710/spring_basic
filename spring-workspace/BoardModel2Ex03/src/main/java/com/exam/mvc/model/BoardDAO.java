package com.exam.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ArrayList<BoardTO> boardList() {

		ArrayList<BoardTO> datas = (ArrayList<BoardTO>) jdbcTemplate.query( 
				"select seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from board1 order by seq desc", 
				new BeanPropertyRowMapper<BoardTO>( BoardTO.class ) 
		);
		
		return datas;
	}
	
	public void boardWrite() {}
	
	public int boardWriteOk(BoardTO to) {

		int result = jdbcTemplate.update( 
				"insert into board1 values ( 0, ?, ?, ?, ?, ?, 0, ?, now() )", 
				to.getSubject(), to.getWriter(), to.getMail(), to.getPassword(), to.getContent(), to.getWip() 
		);

		
		int flag = 2;
		if( result == 0 ) {
			flag = 1;
		} else if( result == 1 ) {
			flag = 0;
		}

		return flag;
	}
	
	public BoardTO boardView(BoardTO to) {

		int result = jdbcTemplate.update( 
				"update board1 set hit=hit+1 where seq=?", 
				to.getSeq() 
		);

		to = jdbcTemplate.queryForObject( 
				"select subject, writer, mail, wip, wdate, hit, content from board1 where seq=?", 
				new BeanPropertyRowMapper<BoardTO>( BoardTO.class ), 
				to.getSeq() 
		);
		
		return to;
	}
	
	public BoardTO boardModify(BoardTO to) {

		to = jdbcTemplate.queryForObject( 
				"select subject, writer, mail, content from board1 where seq=?", 
				new BeanPropertyRowMapper<BoardTO>( BoardTO.class ), 
				to.getSeq() 
		);
		
		return to;
	}
	
	public int boardModifyOk(BoardTO to) {
		
		int result = jdbcTemplate.update( 
				"update board1 set subject=?, mail=?, content=? where seq=? and password=?", 
				to.getSubject(), to.getMail(), to.getContent(), to.getSeq(), to.getPassword() 
		);

		int flag = 2;
		if( result == 0 ) {
			flag = 1;
		} else if( result == 1 ) {
			flag = 0;
		}
		
		return flag;
	}
	
	public BoardTO boardDelete(BoardTO to) {

		to = jdbcTemplate.queryForObject( 
				"select subject, writer from board1 where seq=?", 
				new BeanPropertyRowMapper<BoardTO>( BoardTO.class ), 
				to.getSeq() 
		);
		
		return to;
	}
	
	public int boardDeleteOk(BoardTO to) {

		int result = jdbcTemplate.update( 
				"delete from board1 where seq=? and password=?", 
				to.getSeq(), to.getPassword() 
		);

		int flag = 2;
		if( result == 0 ) {
			flag = 1;
		} else if( result == 1 ) {
			flag = 0;
		}
		
		return flag;
	}
	
}
