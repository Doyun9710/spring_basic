package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SqlMapperInter {

	@Select( "select now() as now" )
	String select();
}
