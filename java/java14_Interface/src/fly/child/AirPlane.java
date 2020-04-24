package fly.child;

import fly.Flyer;

public class AirPlane implements Flyer{
	public void fly() {
		System.out.println("비행기가 난다");
	}
	
	public void land() {
		System.out.println("비행기가 착륙");
		
	}
	public void take_off() {
		System.out.println("비행기가 이륙");
		
	}
}
