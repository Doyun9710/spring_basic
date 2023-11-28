package com.example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackages = { "com.example.config" } )
public class Upload01Application {

	public static void main(String[] args) {
		SpringApplication.run(Upload01Application.class, args);
	}

}
