package com.example.zipcode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.example.model.ZipcodeDAO;
import com.example.model.ZipcodeTO;

@Repository
@ComponentScan( basePackages = { "com.example.model" } )
public class ZipcodeApplication {
	
	@Autowired
	private ZipcodeDAO dao;

	public void searchDong(String strDong) {
		System.out.println( "ZipcodeApplication 호출" );
		
		List<ZipcodeTO> datas = dao.listZipcode(strDong);
		
		for ( ZipcodeTO to : datas ) {
			String zipcode = to.getZipcode();
			String sido = to.getSido();
			String gugun = to.getGugun();
			String dong = to.getDong();
			String ri = to.getRi();
			String bunji = to.getBunji();
			
			System.out.println( "[" + zipcode + "]" + "\t" + sido + "\t" + gugun + "\t" + dong + "\t" + ri + "\t" + bunji );
		}
	}
}
