package exception.runtime.test;

public class RuntimeExceptionTest2 {

	public static void main(String[] args) {
		
		System.out.println("***********NullPointerException************");
		String str = new String("Encore"); //heap
		System.out.println(str); // string은 tostring을 override해서 사용함
		
		str = null;
		try {
			System.out.println("str의 데이터값: "+str); //null
			// NullPointerException : 객체생성하지않고 객체의 멤버에 접근하려고 할때 발생하는 예외.
			// 객체 생성하지 않고 == null
			System.out.println("str의 길이: "+str.length());}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Nice Catch!");
		}
		catch(NullPointerException e) {
			System.out.println("잡았다 요놈");
		}
		catch(Exception e) {
			System.out.println("잡았당~");
		}
		finally {
			System.out.println("필 수 출 력");
		}


	}

}
