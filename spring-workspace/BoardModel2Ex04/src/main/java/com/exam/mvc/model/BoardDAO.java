package com.exam.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	public ArrayList<BoardTO> boardList() {

		List<BoardTO> lists = sqlSession.selectList( "list" );
		ArrayList<BoardTO> datas = new ArrayList<BoardTO>();
		datas.addAll(lists);
		
		return datas;
	}
	
	public void boardWrite() {}
	
	public int boardWriteOk(BoardTO to) {

		int result = sqlSession.insert( "write_ok", to );

		int flag = 2;
		if( result == 0 ) {
			flag = 1;
		} else if( result == 1 ) {
			flag = 0;
		}

		return flag;
	}
	
	public BoardTO boardView(BoardTO to) {

		int result = sqlSession.update( "view_hit", to );

		to = sqlSession.selectOne( "view", to );
		
		return to;
	}
	
	public BoardTO boardModify(BoardTO to) {

		to = sqlSession.selectOne( "modify", to );
		
		return to;
	}
	
	public int boardModifyOk(BoardTO to) {
		
		int result = sqlSession.update( "modify_ok", to );

		int flag = 2;
		if( result == 0 ) {
			flag = 1;
		} else if( result == 1 ) {
			flag = 0;
		}
		
		return flag;
	}
	
	public BoardTO boardDelete(BoardTO to) {

		to = sqlSession.selectOne( "delete", to );

		return to;
	}
	
	public int boardDeleteOk(BoardTO to) {

		int result = sqlSession.update( "delete_ok", to );

		int flag = 2;
		if( result == 0 ) {
			flag = 1;
		} else if( result == 1 ) {
			flag = 0;
		}
		
		return flag;
	}
	
}
