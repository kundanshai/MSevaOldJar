package com.djb.wipro.exception;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class GlobalException extends Throwable implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable arg0) {
		return Response.status(500).entity("Something bad happened. Please try again !!").type("text/plain").build();
	}
	
	

/*	@ExceptionHandler(InvalidKnoException.class)
	public ResponseEntity<ExceptionResponse> getUserExceptio(InvalidKnoException userException,HttpServletRequest request){
		ExceptionResponse exceptionResponse=new ExceptionResponse();
		exceptionResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
		exceptionResponse.setErrorMessage(userException.getMessage());
		exceptionResponse.setErrorUrl(request.getRequestURI());
		return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
		
	}*/
}
