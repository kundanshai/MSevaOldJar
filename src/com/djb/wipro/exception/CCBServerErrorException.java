package com.djb.wipro.exception;

public class CCBServerErrorException extends Exception{
	
	private static final long serialVersionUID = 8386043149239471253L;

	public CCBServerErrorException(String msg){
		super(msg);
	}
}
