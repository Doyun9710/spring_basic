package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.model.ZipcodeTO;

@Mapper
public interface SqlMapperInter {

	@Select( "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like #{ strDong }" )
	List<ZipcodeTO> searchDong(String strDong);
	
}
