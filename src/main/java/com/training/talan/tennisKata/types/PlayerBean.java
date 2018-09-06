package com.training.talan.tennisKata.types;

import com.training.talan.Exceptions.IllegalScoreException;

public class PlayerBean {


	private String name;
	private int score;
	
	public PlayerBean() {
		this.name = "";
		this.score = 0;
	}
	
	public PlayerBean(String name) {
		this.name = name;
		this.score = 0;
	}
	
	public void playerWinsOnePoint() {
		this.score ++ ;
	}
	
	public void resetPlayerScore() {
		this.score = 0 ;
	}
	
	public String printScore() {
		try {
			switch (score) {
			case 3:
				return "40";
			case 2:
				return "30";
			case 1: 
				return "15";
			case 0:
				return "0";
			}
			throw new IllegalScoreException(score);
		}catch (IllegalScoreException e) {
			return e.getMessage();
		}
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
