package com.training.talan.tennisKata.services.impl;


import org.springframework.stereotype.Service;

import com.training.talan.Exceptions.NoSuchPlayerNameException;
import com.training.talan.tennisKata.services.TennisSetService;
import com.training.talan.tennisKata.types.TennisPlayerBean;


@Service
public class TennisSetServiceImpl implements TennisSetService {
	
	private TennisPlayerBean player1;
	private TennisPlayerBean player2;
	
	public TennisSetServiceImpl(TennisPlayerBean player1, TennisPlayerBean player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public boolean isDeuce() {
		return player1.getScore() >= 3 && player2.getScore() == player1.getScore();
	}
	
	public boolean hasAdvantage() {
		if (Math.min(player1.getScore(), player2.getScore()) >= 4 &&
				Math.max(player1.getScore(), player2.getScore()) == (Math.min(player1.getScore(), player2.getScore()) + 1 ))
			return true;
		
		return false;

	}
	
	public String playerWithHighestScore() {
		if (player1.getScore() > player2.getScore()) {
			return player1.getName();
		} else {
			return player2.getName();
		}
	}
	
	public String playerWithHighestSetScore() {
		if (player1.getSetScore() > player2.getSetScore()) {
			return player1.getName();
		} else {
			return player2.getName();
		}
	}
	
	
	public TennisPlayerBean getPlayerByName (String playerName) {
		try {
			if (player1.getName().equals(playerName)) {
				
				return player1;
			}else if (player2.getName().equals(playerName)) {
				
				return player2;
			}else 
				throw new NoSuchPlayerNameException();
			
		}catch (NoSuchPlayerNameException nameException) {
			
			return new TennisPlayerBean(nameException.getMessage());
			
		}
	}
}
