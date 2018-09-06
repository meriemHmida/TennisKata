package com.training.talan.tennisKata;

import com.training.talan.tennisKata.services.impl.TennisGameServiceImpl;

import junit.framework.TestCase;

public class TennisGameTest extends TestCase {
	
	TennisGameServiceImpl game = null;

	public void testStartNewSetAfterPlayerWonSet() {

		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setScore(3);
		game.getPlayer1().setSetScore(1);
		game.getPlayer2().setScore(1);
		
		game.startNewSetAfterPlayerWonSet("Nadal");
		
		assertEquals(2, game.getPlayer1().getSetScore());
		assertEquals(0, game.getPlayer1().getScore());
		assertEquals(0, game.getPlayer2().getScore());
	}

	public void testGetScore1() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setSetScore(6);
		game.getPlayer2().setSetScore(3);
		
		String score = game.getScore();
		
		assertEquals("Nadal won the game!", score);
		
	}
	
	public void testGetScore2() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setScore(3);
		game.getPlayer2().setScore(3);
		
		String score = game.getScore();
		
		assertEquals("Deuce", score);
		
	}
	
	public void testGetScore3() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setScore(4);
		game.getPlayer2().setScore(5);
		
		String score = game.getScore();
		
		assertEquals("Federer has advantage", score);
		
	}
	
	public void testGetScore4() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setScore(3);
		game.getPlayer2().setScore(2);
		
		String score = game.getScore();
		
		assertEquals("40 - 30", score);
		
	}

	public void testIsInTieBreak1() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setSetScore(7);
		game.getPlayer2().setSetScore(8);
		
		assertTrue(game.isInTieBreak());
		
	}
	
	public void testIsInTieBreak2() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setSetScore(3);
		game.getPlayer2().setSetScore(2);
		
		assertFalse(game.isInTieBreak());
	}
	
	public void testGameHasWinner1() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setSetScore(6);
		game.getPlayer2().setSetScore(2);
		
		assertEquals(true, game.gameHasWinner());
	}
	
	public void testGameHasWinner2() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setSetScore(8);
		game.getPlayer2().setSetScore(10);
		
		assertEquals(true, game.gameHasWinner());
	}

	public void testGameHasWinner3() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setSetScore(3);
		game.getPlayer2().setSetScore(2);
		
		assertEquals(false, game.gameHasWinner());
	}

	public void testGameHasWinner4() {
		game = new TennisGameServiceImpl("Nadal", "Federer");
		
		game.getPlayer1().setSetScore(8);
		game.getPlayer2().setSetScore(9);
		
		assertEquals(false, game.gameHasWinner());
	}
}

