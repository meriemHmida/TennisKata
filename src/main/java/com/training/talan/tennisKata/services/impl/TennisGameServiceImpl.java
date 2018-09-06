package com.training.talan.tennisKata.services.impl;

import org.springframework.stereotype.Service;

import com.training.talan.tennisKata.services.TennisGameService;
import com.training.talan.tennisKata.types.TennisPlayerBean;

@Service
public class TennisGameServiceImpl  implements TennisGameService{

	private TennisPlayerBean player1;
	private TennisPlayerBean player2;
	private TennisSetServiceImpl tennisSet;
	
	
	public TennisGameServiceImpl(String player1Name, String player2Name) {
		this.player1 = new TennisPlayerBean(player1Name);
		this.player2 = new TennisPlayerBean(player2Name);
		this.tennisSet = new TennisSetServiceImpl(this.player1, this.player2);
	}
	
	public TennisGameServiceImpl(TennisPlayerBean player1, TennisPlayerBean player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.tennisSet = new TennisSetServiceImpl(player1, player2);
	}
	
	
	public void startNewSetAfterPlayerWonSet(String player) {
		
		setTennisSet(new TennisSetServiceImpl(player1, player2));
		player1.resetPlayerScore();
		player2.resetPlayerScore();
		tennisSet.getPlayerByName(player).playerWinsSet();
		
	}
	
	public String getScore() {
		
		String score = "";
		
		if (gameHasWinner()) {
			
			score = tennisSet.playerWithHighestSetScore() + " won the game!";
		
		}else if (tennisSet.isDeuce()) {
			
			score = "Deuce";
			
		}else if (player1.getScore() < 4 
				&& player2.getScore() < 4) {
			
			score = player1.printScore() + " - " + player2.printScore();
			
		}else if (tennisSet.hasAdvantage()) {
			
			score = tennisSet.playerWithHighestScore() + " has advantage";
		}
		
		
		return score;
	}

	public boolean isInTieBreak() {
		
		return Math.min(player1.getSetScore(), player2.getSetScore()) >= 7 ;
	}
	

	public boolean gameHasWinner() {
		
		if (isInTieBreak() && Math.abs(player1.getSetScore() - player2.getSetScore()) >= 2) {
			
			return true;
			
		} else if (Math.min(player1.getSetScore(), player2.getSetScore()) <= 4 
				&& Math.max(player1.getSetScore(), player2.getSetScore()) == 6) {
		
			return true;
		}
		
		return false;
		
	}
	
	
	public TennisPlayerBean getPlayer1() {
		return player1;
	}
	public void setPlayer1(TennisPlayerBean player1) {
		this.player1 = player1;
	}
	public TennisPlayerBean getPlayer2() {
		return player2;
	}
	public void setPlayer2(TennisPlayerBean player2) {
		this.player2 = player2;
	}


	public TennisSetServiceImpl getTennisSet() {
		return tennisSet;
	}


	public void setTennisSet(TennisSetServiceImpl tennisSet) {
		this.tennisSet = tennisSet;
	}
	
	
	
}
