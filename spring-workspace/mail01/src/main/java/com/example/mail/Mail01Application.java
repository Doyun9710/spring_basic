package com.example.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackages = { "com.example.controller" } )
public class Mail01Application {

	public static void main(String[] args) {
		SpringApplication.run(Mail01Application.class, args);
	}

}
