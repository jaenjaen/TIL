package fly.child;

import fly.Flyer;
/*
 * 인터페이스를 부모로 둔 자식은(Bird) 반드시 부모가 가진 모든 추상메소드를
 * 무 조 건 다 구현해야 함 결론적으로 오버라이딩 한 것
 */
public abstract class Bird implements Flyer{
	/*public void fly() {
		System.out.println("새가 난다");
	}*/
	
	public void land() {
		System.out.println("새가 착륙");
		
	}
	public void take_off() {
		System.out.println("새가 뜬다");
		
	}
	
	public String layEggs() {
		return "알을 낳는다";
	}
}
