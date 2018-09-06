package com.training.talan.tennisKata;

import com.training.talan.tennisKata.services.impl.TennisGameServiceImpl;

import junit.framework.TestCase;

public class TennisSetTest extends TestCase {
	
	TennisGameServiceImpl game = null;

	public void testIsDeuce1() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setScore(3);
		game.getPlayer2().setScore(3);
		
		assertTrue(game.getTennisSet().isDeuce());
	}
	
	public void testIsDeuce2() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setScore(3);
		game.getPlayer2().setScore(2);
		
		assertFalse(game.getTennisSet().isDeuce());
	}

	public void testHasAdvantage1() {
		
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setScore(3);
		game.getPlayer2().setScore(2);
		
		assertFalse(game.getTennisSet().hasAdvantage());
	}
	
	public void testHasAdvantage2() {
		
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setScore(5);
		game.getPlayer2().setScore(4);
		
		assertTrue(game.getTennisSet().hasAdvantage());
	}

	public void testPlayerWithHighestScore() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setScore(3);
		game.getPlayer2().setScore(0);
		
		assertEquals("Nadal", game.getTennisSet().playerWithHighestScore());
	}

	public void testPlayerWithHighestSetScore() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setSetScore(3);
		game.getPlayer2().setSetScore(4);
		
		assertEquals("Federer", game.getTennisSet().playerWithHighestSetScore());
	}
	
	public void testGetPlayerByName1() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		assertEquals(game.getPlayer1().getName(), game.getTennisSet().getPlayerByName("Nadal").getName());
		
	}
	
	public void testGetPlayerByName2() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		assertEquals("Player does not exist", game.getTennisSet().getPlayerByName("Mickel").getName());
		
	}
}
