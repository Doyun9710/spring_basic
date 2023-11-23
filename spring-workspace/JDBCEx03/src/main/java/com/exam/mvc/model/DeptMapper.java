package com.exam.mvc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DeptMapper implements RowMapper<DeptTO> {

	@Override
	public DeptTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		DeptTO to = new DeptTO();

		to.setDeptno( rs.getString( "deptno" ) );
		to.setDname( rs.getString( "dname" ) );
		to.setLoc( rs.getString( "loc" ) );
		
		return to;
	}

}