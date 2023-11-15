package com.exam.di04.config;

import org.springframework.context.annotation.Bean;

import com.exam.di04.model1.BoardDAO;
import com.exam.di04.model2.ListAction;

public class BeanConfig {
	BoardDAO dao = new BoardDAO();
	
	@Bean
	public ListAction listAction() {
		return new ListAction( dao );
	}
	
}
