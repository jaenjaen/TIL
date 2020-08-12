package com.encore.rest.domain;

public class Person {
	private String name;
	private String msg;
	
	public Person() {}
	public Person(String name, String msg) {
		super();
		this.name = name;
		this.msg = msg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", msg=" + msg + "]";
	}
	
}
