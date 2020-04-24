package exam.test;

/*
 *  final 키워드 + static
 *  
 */

class A{
	public final static int BASE_SALARY =300; //어디든 동일한 갑으로 공유되어야 하기 때문에 public 붙임
	
	public final String test() {
		return "Overriding 금지";
	}
}

//상속금지
final class B{}

/*class C extends B{}*/ //에러남

/*class D extends A{
	public final String test() {
		return "Overriding 금지";
	} // 부모거를 그대로 안갖다 쓰고 자식으로 가져왔다는건 오버라이딩 하겠다는 뜻이기 때문에 에러남
}
*/
public class StaticExamTest4 {

	
	public static void main(String[] args) {
		
		
	}

}
