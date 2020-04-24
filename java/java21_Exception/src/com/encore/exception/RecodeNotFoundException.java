package com.encore.exception;

public class RecodeNotFoundException extends Exception{
	public RecodeNotFoundException(){
		this("RecodeNotFoundException!!!");
	}
	
	public RecodeNotFoundException(String msg) {
		super(msg);
	}

}
