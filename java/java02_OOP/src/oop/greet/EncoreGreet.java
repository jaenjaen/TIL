package oop.greet;

/* EncoreGreet 클래스의 용도
 * EncoreGreet 는
 * Ecore 교육센터 수강생들에게 전하는 인사말을 저장하고 있는 클래스 
 */
public class EncoreGreet {
	//var : Field - saved value
	public String name = "James"; // initialization
	public String message = "Hello! Gday mate!";
	
	//add filed
	public int classRoom;
	public String subject;
	

	//method (기능)
	public void sayHello(){
		System.out.println(name+","+message); 
	}
	//메소드 추가
	public String getEncore() {
		return name+"\t"+message+"\t"+classRoom+"\t"+subject;
	}
	
	//함수추가.. 여러개의 값을 한번에 필드에 주입하는 기능을 규현
	//메소드 정의 = 메소드선언부 + 메소드 구현부
	public void setEncore(String n, String m, int c, String s) {
		name = n;
		message = m;
		classRoom = c;
		subject = s;
	}
}
