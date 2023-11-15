package com.exam.di05.config;

import org.springframework.context.annotation.Import;

@Import( { BeanConfig1.class, BeanConfig2.class } )
public class BeanConfig {
	
}
