package exam.test;

//필드와 static 변수가 어떻게 다른지 확실히 구분
//static 변수는 생성된 객체들이 값을 공유함

class Car{
	int serialNumber;
	static int counter;
	
	Car(){
		counter++; //1
		serialNumber = counter;
	}
	
}


public class StaticExamTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		
		System.out.println("*******************field**************");
		System.out.println(car1.serialNumber);
		System.out.println(car2.serialNumber);
		System.out.println(car3.serialNumber);
		
		System.out.println("*******************static**************");
		System.out.println(Car.counter);
		System.out.println(car1.counter);
		System.out.println(car2.counter);
		System.out.println(car3.counter);
		
		
	}

}
