package fly.test;

import fly.Flyer;
import fly.child.AirPlane;
import fly.child.Bird;
import fly.child.Superman;

public class FlyerTest {

	public static void main(String[] args) {
		
		//polymorphism
		Flyer bird = new Bird();
		Flyer ap = new AirPlane();
		Flyer sm = new Superman();
		
		//
		bird.fly();//virtual method invocation 원리 오버라이딩 된 메소드에서만 나타남
		
		//자식클래스의 메소드를 가져오기 위해 casting
		System.out.println(((Bird)bird).layEggs());
		}
}
