package com.example.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.model.ZipcodeDAO;
import com.example.model.ZipcodeTO;
import com.example.zipcode.ZipcodeApplication;

@SpringBootApplication
@ComponentScan( basePackages = { "com.example.zipcode", "com.example.model" } )
public class Boot04Application implements CommandLineRunner {
	
	@Autowired
	private ZipcodeApplication zipcodeApplication;
	/*
	@Autowired
	private ZipcodeDAO dao;
	*/
	public static void main(String[] args) {
		SpringApplication.run(Boot04Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "main run() 호출" );
		
		zipcodeApplication.searchDong( "신사" );
		/*
		List<ZipcodeTO> datas = dao.searchZipcode( "신사" );
		
		for ( ZipcodeTO to : datas ) {
			String zipcode = to.getZipcode();
			String sido = to.getSido();
			String gugun = to.getGugun();
			String dong = to.getDong();
			String ri = to.getRi();
			String bunji = to.getBunji();
			
			System.out.println( "[" + zipcode + "]" + "\t" + sido + "\t" + gugun + "\t" + dong + "\t" + ri + "\t" + bunji );
		}
		*/
	}

}
