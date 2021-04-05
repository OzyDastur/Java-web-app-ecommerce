package com.concordia.exception;

public class EmailException extends Exception { 
	
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6852768609975772363L;

	public EmailException(String errorMessage) {
        super(errorMessage);
    }
}
