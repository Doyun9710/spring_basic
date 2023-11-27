package com.example.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.mapper.ZipcodeMapperInter;

@Repository
@MapperScan( basePackages = { "com.example.mapper" } )
public class ZipcodeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ZipcodeMapperInter mapper;

	public List<ZipcodeTO> listZipcode(String strDong) {
		System.out.println( "ZipcodeDAO() listZipcode() 호출" );

		List<ZipcodeTO> lists = mapper.searchDong( strDong + "%" );
	
		return lists;
	}
}
