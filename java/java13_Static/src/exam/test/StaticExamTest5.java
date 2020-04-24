package exam.test;

class Factory{
	private static Factory factory = new Factory();
	
	private Factory() {
		System.out.println("****Car Factory creating****");
	}
	
	public static Factory getInstance() {
		return factory;
	}
}

public class StaticExamTest5 {

	
	public static void main(String[] args) {
		
		//Factory f = new Factory(); //생성자 호출을 막아놔서 안됨
		Factory factory1 = Factory.getInstance();
		Factory factory2 = Factory.getInstance();
		Factory factory3 = Factory.getInstance();
		
		//같은 주소값 할당
		System.out.println(factory1);
		System.out.println(factory2);
		System.out.println(factory3);
		
	}

}
