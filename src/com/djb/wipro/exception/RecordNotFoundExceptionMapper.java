package com.djb.wipro.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RecordNotFoundExceptionMapper implements ExceptionMapper<RecordNotFoundException>{
	
	@Override
	public Response toResponse(RecordNotFoundException exc) {
		
		ExceptionResponse exceptionResponse=new ExceptionResponse(404,exc.getMessage(),false);
		return Response.status(Status.NOT_FOUND).entity(exceptionResponse).build();
		
	}

}
