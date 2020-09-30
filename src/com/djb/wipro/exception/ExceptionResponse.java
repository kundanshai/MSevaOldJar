package com.djb.wipro.exception;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExceptionResponse{

private static final long serialVersionUID = -1316904234254043931L;
private int errorCode;
private String errorMessage;
private boolean status;


public ExceptionResponse(int errorCode, String errorMessage,boolean status) {
	this.errorCode=errorCode;
	this.errorMessage=errorMessage;
	this.status=status;
}
public int getErrorCode() {
	return errorCode;
}
public void setErrorCode(int errorCode) {
	this.errorCode = errorCode;
}
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}


}
