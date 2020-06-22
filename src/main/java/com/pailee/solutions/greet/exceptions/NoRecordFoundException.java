package com.pailee.solutions.greet.exceptions;

public class NoRecordFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	 public NoRecordFoundException(String message)
	    {
	        super(message);
	    }

}
