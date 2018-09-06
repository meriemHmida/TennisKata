package com.training.talan.Exceptions;

public class IllegalScoreException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IllegalScoreException(int score) {
		super("Illegal score: " + score);
	}
}
