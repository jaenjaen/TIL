package exception.runtime.test;

public class RuntimeExceptionTest1 {

	public static void main(String[] args) {
		String [] str = {
				"Hello Java!",
				"No I mean it ㅡㅡ",
				"Nice to meet U"};
		
		int i = 0;
		
		while(i<=3) {
			try {
			System.out.println(str[i++]);}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("\noNICE CATCH!");
			}
		}
	}
}