package com.djb.wipro.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class InvalidKnoExceptionMapper implements ExceptionMapper<InvalidKnoException> {

	@Override
	public Response toResponse(InvalidKnoException exception) {
		
		ExceptionResponse exceptionResponse=new ExceptionResponse(404,exception.getMessage(),false);
		
		return Response.status(Status.NOT_FOUND).entity(exceptionResponse).build();
	}

}
