package com.abcrent.child;

import com.abcrent.parent.Vehicle;

public class Motocycle extends Vehicle{
	private int wheel;

	public Motocycle(int num, String model, int price,int wheel) {
		super(num,model,price);
		this.wheel = wheel;
	}
	
	
	public String toString(){
		// TODO Auto-generated method stub
		return super.toString()+" 바퀴 수: "+wheel+"륜 구동";
	}

	
}
