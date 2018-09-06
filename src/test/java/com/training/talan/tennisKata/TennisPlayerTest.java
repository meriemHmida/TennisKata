package com.training.talan.tennisKata;

import com.training.talan.tennisKata.types.TennisPlayerBean;

import junit.framework.TestCase;

public class TennisPlayerTest extends TestCase {

	TennisPlayerBean player = new TennisPlayerBean("Nadal");
	
	public void testPlayerWinsOnePoint() {
		player.playerWinsOnePoint();
		player.playerWinsOnePoint();
		
		assertEquals(2, player.getScore());
	}

	public void testPlayerWinsSet() {
		player.playerWinsSet();
		
		assertEquals(1, player.getSetScore());
		
	}

	public void testResetPlayerScore() {

		player = new TennisPlayerBean("Nadal");
		player.playerWinsOnePoint();
		assertEquals(1, player.getScore());
		
		player.resetPlayerScore();
		assertEquals(0, player.getScore());
		
	}

	public void testPrintScore1() {
		
		player.setScore(2);
		
		assertEquals("30", player.printScore());
	}

	public void testPrintScore2() {
		
		player.setScore(4);
		
		assertEquals("Illegal score: 4", player.printScore());
	}
}
