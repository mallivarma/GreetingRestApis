package com.pailee.solutions.greet.exceptions;

public class CouldNotUpdateRecordException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 public CouldNotUpdateRecordException(String message)
	    {
	        super(message);
	    }

}
