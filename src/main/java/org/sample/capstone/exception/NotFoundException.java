package org.sample.capstone.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8341124957351263968L;

	public NotFoundException(String message) {
		super(message);
	}

}
