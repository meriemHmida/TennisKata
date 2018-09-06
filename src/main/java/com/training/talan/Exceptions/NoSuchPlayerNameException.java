package com.training.talan.Exceptions;

public class NoSuchPlayerNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoSuchPlayerNameException() {
		super("Player does not exist");
	}
}
