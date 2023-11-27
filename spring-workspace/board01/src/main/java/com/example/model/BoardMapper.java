package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoardMapper implements RowMapper<BoardTO> {

	@Override
	public BoardTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		BoardTO to = new BoardTO();

		to.setSeq( rs.getString( "seq" ) );
		to.setSubject( rs.getString( "subject" ) );
		to.setWriter( rs.getString( "writer" ) );
		to.setMail( rs.getString( "mail" ) );
		to.setPassword( rs.getString( "password" ) );
		to.setContent( rs.getString( "content" ) );
		to.setHit( rs.getString( "hit" ) );
		to.setWip( rs.getString( "wip" ) );
		to.setWdate( rs.getString( "wdate" ) );
		to.setWgap( rs.getInt( "wgap" ) );
		
		return to;
	}

}