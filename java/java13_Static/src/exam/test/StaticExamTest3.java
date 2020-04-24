package exam.test;

//static block
public class StaticExamTest3 {

	static int i;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1. main method static block "+i);
		
		//객체생성 (생성자 알고리즘 실행 -> initialization됨
	}
	
	//global한 값을 초기화 함
	static {
		i = 300;
		System.out.println("2. static initailization block "+i);
	}

}
