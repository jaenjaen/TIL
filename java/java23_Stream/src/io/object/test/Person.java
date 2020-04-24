package io.object.test;

import java.io.Serializable;

/*
 * 직렬화 == OjbectOutputStream -> Sink로
 * 정확히 말하면 객체의 필드값이 날라가는 것
 * 
 * 이렇게 Person이 객체 String을 직렬화로 통과하려면
 * 반드시 serializable을 implements해야함 안하면
 * 통과 안됨 
 */
public class Person implements Serializable {
	private String name;
	private int age;
	private String password;
	
	public Person(String name, int age, String password) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "person [name=" + name + ", age=" + age + ", password=" + password + "]";
	}

}
