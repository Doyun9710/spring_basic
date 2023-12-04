package com.example.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackages = { "com.example.controller", "com.example.model" } )
public class ThymeleafBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafBoardApplication.class, args);
	}

}
