package com.training.talan.tennisKata;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.talan.tennisKata.types.TennisPlayerBean;

@Configuration
public class TennisGameConfig {
	
	@Bean(name= {"player1","player2"})
	public TennisPlayerBean tennisPlayerBean() {
		return new TennisPlayerBean();
	}
	
	
}
