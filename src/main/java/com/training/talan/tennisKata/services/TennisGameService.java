package com.training.talan.tennisKata.services;

public interface TennisGameService {

	void startNewSetAfterPlayerWonSet(String player);
	
	public String getScore();
		
	boolean isInTieBreak();

	boolean gameHasWinner(); 
	
}
