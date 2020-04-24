package com.abcrent.child;

import com.abcrent.parent.Vehicle;

public class Limousine extends Vehicle{
	private int people;

	public Limousine(int num, String model, int price,int people) {
		super(num, model, price);
		this.people = people;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" 인승: "+people+"인승용";
	}

}
