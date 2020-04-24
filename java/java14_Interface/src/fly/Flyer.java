package fly;


//나는 것과 관련된 templet
//완벽한 추상화 - 구현된 것이 하나도 없어야 인터페이스임
//인터페이스 구성요소 = 추상메소드 + 상수
public interface Flyer {
	public static final int SIZE = 100;
	
	void fly(); //public abstract가 void 앞에 생략됨
	void land();
	void take_off();
}
