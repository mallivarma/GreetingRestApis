package com.pailee.solutions.greet.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.pailee.solutions.greet.exceptions.MissingRequiredFieldException;
import com.pailee.solutions.greet.utils.GreetErrorMessage;
import com.pailee.solutions.greet.utils.GreetErrorMessages;

@Provider
public class MissingRequiredFieldExceptionMapper implements ExceptionMapper<MissingRequiredFieldException>{


	@Override
	public Response toResponse(MissingRequiredFieldException exception) {
		 GreetErrorMessage errorMessage = new GreetErrorMessage(exception.getMessage(),
				 GreetErrorMessages.MISSING_REQUIRED_FIELD.name(), "http://paileeinfosolutions.com");
	        
	      return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
	}

}
