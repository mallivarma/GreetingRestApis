package com.pailee.solutions.greet.exceptions;

public class CouldNotDeleteRecordException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 public CouldNotDeleteRecordException(String message)
	    {
	        super(message);
	    }

}
