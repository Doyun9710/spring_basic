package com.example.zipcode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.model.ZipcodeDAO;
import com.example.model.ZipcodeTO;

@SpringBootApplication
@ComponentScan( basePackages = { "com.example.model" } )
public class ZipcodeApplication implements CommandLineRunner {

	@Autowired
	private ZipcodeDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(ZipcodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		searchDong();
	}
	
	public void searchDong() {
		System.out.println( "searchDong() 호출" );
		
		List<ZipcodeTO> lists =  dao.listZipcode( "신사" );
		
		for ( ZipcodeTO to : lists ) {
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
