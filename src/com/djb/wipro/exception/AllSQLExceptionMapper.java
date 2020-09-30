package com.djb.wipro.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

public class AllSQLExceptionMapper implements ExceptionMapper<AllSQLException>{

	@Override
	public Response toResponse(AllSQLException exce) {
		
		ExceptionResponse exceptionResponse=new ExceptionResponse(500, exce.getMessage(), false);
		
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(exceptionResponse).build();
	}

}
