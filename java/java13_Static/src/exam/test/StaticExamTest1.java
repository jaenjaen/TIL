package exam.test;

class Member{
	static final String name = "길동이";
	static final int age =22; //static변수, class변수, 전역변수
	int count = 1; //필드, 멤버v
	
	public static void getMember(){
		System.out.println("우/유/빛/깔 "+name);
		System.out.println("count: " + count);
	}
	
	//non-static
	public void getMember2(){
		System.out.println("우/유/빛/깔 "+name);
	}
}
public class StaticExamTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Member m = new Member();
		m.getMember();*/

		Member.getMember();
		//Member.getMember2();
	}

}
