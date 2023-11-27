package com.example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackages = { "com.example.config" } )
public class Mybatis01Application {

	public static void main(String[] args) {
		SpringApplication.run(Mybatis01Application.class, args);
	}

}
