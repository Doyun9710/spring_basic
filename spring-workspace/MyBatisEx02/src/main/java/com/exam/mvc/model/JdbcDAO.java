package com.exam.mvc.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public void selectNow() {
		String result = sqlSession.selectOne( "selectNow" );
		System.out.println( "결과 : " + result );
	}
}
