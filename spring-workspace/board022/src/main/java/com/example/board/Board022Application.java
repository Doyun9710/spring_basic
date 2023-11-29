package com.example.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackages = { "com.example.controller", "com.example.model" } )
public class Board022Application {

	public static void main(String[] args) {
		SpringApplication.run(Board022Application.class, args);
	}

}
