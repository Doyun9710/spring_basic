package com.example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackages = { "com.example.config", "com.example.model" } )
public class Board01Application {

	public static void main(String[] args) {
		SpringApplication.run(Board01Application.class, args);
	}

}
