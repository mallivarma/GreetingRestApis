package com.pailee.solutions.greet.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.pailee.solutions.greet.exceptions.NoRecordFoundException;
import com.pailee.solutions.greet.utils.GreetErrorMessage;
import com.pailee.solutions.greet.utils.GreetErrorMessages;

@Provider
public class NoRecordFoundExceptionMapper implements ExceptionMapper<NoRecordFoundException>{

	@Override
	public Response toResponse(NoRecordFoundException exception) {
		 GreetErrorMessage errorMessage = new GreetErrorMessage(exception.getMessage(),
				 GreetErrorMessages.MISSING_REQUIRED_FIELD.name(), "http://paileeinfosolutions.com");
	        
	      return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
	}
	
}
