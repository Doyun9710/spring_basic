package com.example.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackages = { "com.example.controller" } )
public class Thymeleaf01Application {

	public static void main(String[] args) {
		SpringApplication.run(Thymeleaf01Application.class, args);
	}

}
