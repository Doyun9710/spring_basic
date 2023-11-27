package com.example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackages = { "com.example.config" } )
public class Web02Application {

	public static void main(String[] args) {
		SpringApplication.run(Web02Application.class, args);
	}

}
