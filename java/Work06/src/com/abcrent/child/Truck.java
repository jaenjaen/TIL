package com.abcrent.child;

import com.abcrent.parent.Vehicle;

public class Truck extends Vehicle{
	private String capacity;

	public Truck(int num, String model, int price,String capacity) {
		super(num, model, price);
		this.capacity = capacity;
	}
	
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}


	public String toString(){
		// TODO Auto-generated method stub
		return super.toString()+" 용량: "+capacity;
	}

}
