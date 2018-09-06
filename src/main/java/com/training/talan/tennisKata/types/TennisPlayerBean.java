package com.training.talan.tennisKata.types;

import org.springframework.stereotype.Component;

@Component
public class TennisPlayerBean  extends PlayerBean{

	private int setScore;
	
	public TennisPlayerBean() {
		super();
		this.setScore = 0;
	}
	
	public TennisPlayerBean(String name) {
		super(name);
		this.setScore = 0;
	}
	
	
	public void playerWinsSet() {
		this.setScore ++ ;
	}
	
		public int getSetScore() {
		return setScore;
	}

	public void setSetScore(int setScore) {
		this.setScore = setScore;
	}
	
}
