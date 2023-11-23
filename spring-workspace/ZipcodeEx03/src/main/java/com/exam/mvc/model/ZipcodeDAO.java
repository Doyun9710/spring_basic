package com.exam.mvc.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ZipcodeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<ZipcodeTO> listZipcode(String strDong) {
		/*
		List<ZipcodeTO> lists = jdbcTemplate.query( 
				"select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?", 
				new BeanPropertyRowMapper<ZipcodeTO>( ZipcodeTO.class ), 
				strDong + "%" 
		);
		*/
		
		List<ZipcodeTO> lists = jdbcTemplate.query( 
				"select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?", 
				new ZipcodeMapper(), 
				strDong + "%" 
		);
	
		return lists;
	}
}
