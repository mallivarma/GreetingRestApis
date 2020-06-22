package com.pailee.solutions.greet.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.pailee.solutions.greet.exceptions.CouldNotUpdateRecordException;
import com.pailee.solutions.greet.utils.GreetErrorMessage;
import com.pailee.solutions.greet.utils.GreetErrorMessages;

@Provider
public class CouldNotUpdateRecordExceptionMapper implements ExceptionMapper<CouldNotUpdateRecordException>{

	@Override
	public Response toResponse(CouldNotUpdateRecordException exception) {
		 GreetErrorMessage errorMessage = new GreetErrorMessage(exception.getMessage(),
				 GreetErrorMessages.RECORD_ALREADY_EXISTS.name(), "http://paileeinfosolutions.com");
	        
	      return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
	}

}
