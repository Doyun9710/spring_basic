package com.example.boot01;

import javax.swing.JFrame;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot01Application implements CommandLineRunner {

	public static void main(String[] args) {
		// 직접적인 코드 기술 X
		SpringApplication.run(Boot01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "Hello Spring Boot" );
		
		for( String arg : args ) {
			System.out.println( arg );
		}
		
		// JFrame
		JFrame frame = new JFrame();

	}

}
