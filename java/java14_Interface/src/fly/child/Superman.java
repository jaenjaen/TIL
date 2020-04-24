package fly.child;

import fly.Flyer;

/*
 * Stop_bullet()
 */
public class Superman implements Flyer {

	public void fly() {
		System.out.println("슈퍼맨이 난다");
		System.out.println("시속 : "+SIZE+"km");
	}
	
	public void land() {
		System.out.println("슈퍼맨이 착륙");
		
	}
	public void take_off() {
		System.out.println("슈퍼맨 이륙");
		
	}
	
	public String stop_bullet() {
		return "슈퍼맨이 총알을 막았다!";
	}
}
