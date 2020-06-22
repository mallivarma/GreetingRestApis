package com.pailee.solutions.greet.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.pailee.solutions.greet.exceptions.EmailVerificationException;
import com.pailee.solutions.greet.utils.GreetErrorMessage;
import com.pailee.solutions.greet.utils.GreetErrorMessages;
@Provider
public class EmailVerificationExceptionMapper implements ExceptionMapper<EmailVerificationException>{

    public Response toResponse(EmailVerificationException exception) {
         GreetErrorMessage errorMessage = new GreetErrorMessage(
                exception.getMessage(),
                GreetErrorMessages.EMAIL_ADDRESS_NOT_VERIFIED.name(), 
                "http://paileeinfosolutions.com");
    
        return Response.status(Response.Status.FORBIDDEN).
                entity(errorMessage).
                build();
    }
}
