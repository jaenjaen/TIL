package com.encore.exception;

public class DuplicateNameException extends Exception{
	public DuplicateNameException(){
		this("DuplicateNameException!!!");
	}
	
	public DuplicateNameException(String msg) {
		super(msg);
	}

}
