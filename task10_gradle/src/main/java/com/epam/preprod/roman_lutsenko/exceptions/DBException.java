package com.epam.preprod.roman_lutsenko.exceptions;

/**
 * An exception that provides information on a database access error.
 *
 * @author Roman Lutsenko
 *
 */
public class DBException extends RuntimeException{

	public DBException() {
		super();
	}

	public DBException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBException(String message) {
		super(message);
	}
}
