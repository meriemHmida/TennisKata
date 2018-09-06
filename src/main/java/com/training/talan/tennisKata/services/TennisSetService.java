package com.training.talan.tennisKata.services;

import com.training.talan.tennisKata.types.TennisPlayerBean;

public interface TennisSetService {
	
	boolean isDeuce();
	
	boolean hasAdvantage();
	
	String playerWithHighestScore();
	
	String playerWithHighestSetScore() ;
	
	TennisPlayerBean getPlayerByName (String playerName);
}
