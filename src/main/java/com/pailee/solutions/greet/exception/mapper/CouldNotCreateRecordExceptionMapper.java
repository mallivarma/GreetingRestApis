package com.pailee.solutions.greet.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.pailee.solutions.greet.exceptions.CouldNotCreateRecordException;
import com.pailee.solutions.greet.utils.GreetErrorMessage;
import com.pailee.solutions.greet.utils.GreetErrorMessages;
@Provider
public class CouldNotCreateRecordExceptionMapper implements ExceptionMapper<CouldNotCreateRecordException>{

	@Override
	public Response toResponse(CouldNotCreateRecordException exception) {
		 GreetErrorMessage errorMessage = new GreetErrorMessage(exception.getMessage(),
				 GreetErrorMessages.RECORD_ALREADY_EXISTS.name(), "http://paileeinfosolutions.com");
	        
	      return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
	}

}
